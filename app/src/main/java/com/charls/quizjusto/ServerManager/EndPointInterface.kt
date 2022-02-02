package com.charls.quizjusto.ServerManager

import com.charls.quizjusto.JustoModule.JustoProfileModel
import io.reactivex.Single
import retrofit2.http.GET

interface EndPointInterface {
    @GET("/api")
    fun getProfiles(): Single<JustoProfileModel>
}