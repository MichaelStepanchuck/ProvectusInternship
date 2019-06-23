package com.example.provectusinternship

import com.example.provectusinternship.model.RandomUserResponse
import io.reactivex.Single
import retrofit2.http.GET


interface RandomUserAPI {


    @GET("/api/?format=XML&results=5")
    fun getRandomUsers(): Single<RandomUserResponse>

    @GET("/api/?format=XML")
    fun getRandomUser(): Single<RandomUserResponse>

    object Factory {
        fun create(): RandomUserAPI {
            return ServiceFactory.createRetrofitService(RandomUserAPI::class.java, SERVICE_ENDPOINT)
        }
    }

    companion object {
        val SERVICE_ENDPOINT = "https://randomuser.me"
    }
}