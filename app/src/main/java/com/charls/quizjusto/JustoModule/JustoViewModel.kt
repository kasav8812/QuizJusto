package com.charls.quizjusto.JustoModule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.charls.quizjusto.ServerManager.Resource
import com.charls.quizjusto.ServerManager.ServiceApiManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class JustoViewModel(private val mApi: ServiceApiManager) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val mReturnData = MutableLiveData<Resource<JustoProfileModel>>()

    init {
        consumingAPI()
    }

    private fun consumingAPI() {
        mReturnData.postValue(Resource.loading(null))
        compositeDisposable.add(
            mApi.apiInterface.getProfiles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ listProfiles ->
                    mReturnData.postValue(Resource.success(listProfiles))
                }, { throwable ->
                    mReturnData.postValue(Resource.error("An Error :(" + throwable.message.toString(), null))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun showProfiles(): LiveData<Resource<JustoProfileModel>>{
        return mReturnData
    }
}