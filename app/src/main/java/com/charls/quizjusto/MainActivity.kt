package com.charls.quizjusto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.charls.quizjusto.JustoModule.JustoAdapter
import com.charls.quizjusto.JustoModule.JustoProfileModel
import com.charls.quizjusto.JustoModule.JustoViewModel
import com.charls.quizjusto.JustoModule.ViewModelFactory
import com.charls.quizjusto.ServerManager.Status
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mJustoViewModel: JustoViewModel
    private lateinit var mAdapter : JustoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        createTable()
        getProfiles()
    }

    fun getProfiles(){
        mJustoViewModel.showProfiles().observe(this, Observer {
            when(it.status){
                Status.SUCCESS->{
                    it.data?.let { justoProfile -> populateProfiles(justoProfile) }
                }

                Status.LOADING->{
                    Log.d("Loading", "Please Wait")
                }

                Status.ERROR->{
                    Log.e("Error","Has ocurred an error : " + it.message.toString())
                }
            }
        })
    }

    fun populateProfiles(mJustoProfiles : JustoProfileModel){
        mAdapter.updateList(mJustoProfiles.results)
        mAdapter.notifyDataSetChanged()
    }

    fun createTable(){
        mListProfileRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter = JustoAdapter(arrayListOf())
        mListProfileRecyclerView.adapter = mAdapter
    }

    private fun setupViewModel() {
        mJustoViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory()
        ).get(JustoViewModel::class.java)
    }

}