package com.charls.quizjusto.JustoModule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.charls.quizjusto.ServerManager.ServiceApiManager

class ViewModelFactory() : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(JustoViewModel::class.java)) {
            return JustoViewModel(ServiceApiManager) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}