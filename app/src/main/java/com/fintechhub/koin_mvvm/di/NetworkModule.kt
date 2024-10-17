package com.fintechhub.koin_mvvm.di
import com.fintechhub.koin_mvvm.api.TweetsyApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    // Provide Retrofit instance
    single {
        Retrofit.Builder()
            .baseUrl("https://api.jsonbin.io/") // Replace with the actual base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Provide TweetsyApi instance
    single<TweetsyApi> {
        get<Retrofit>().create(TweetsyApi::class.java)
    }
}
