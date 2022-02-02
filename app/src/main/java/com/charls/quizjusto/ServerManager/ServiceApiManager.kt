package com.charls.quizjusto.ServerManager
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceApiManager  {
    val retrofitClient: Retrofit.Builder by lazy {
        val okhttpClient = OkHttpClient.Builder()
        Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .client(okhttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }
    val apiInterface: EndPointInterface by lazy {
        retrofitClient
            .build()
            .create(EndPointInterface::class.java)
    }
}