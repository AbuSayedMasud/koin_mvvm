package com.fintechhub.koin_mvvm.di
import com.fintechhub.koin_mvvm.api.TweetsyApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class NetworkModule {
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.jsonbin.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
//    fun provideTweetsyApi(retrofit: Retrofit): TweetsyApi {
//        return retrofit.create(TweetsyApi::class.java)
//    }
}