package com.example.provectusinternship

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

object ServiceFactory {

    fun <T> createRetrofitService(clazz: Class<T>, endPoint: String): T {

        val restAdapter = Retrofit.Builder()
            .baseUrl(endPoint)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()

        return restAdapter.create(clazz)
    }

}