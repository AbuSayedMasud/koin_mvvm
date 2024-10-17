package com.fintechhub.koin_mvvm

import androidx.lifecycle.SavedStateHandle
import com.fintechhub.koin_mvvm.api.TweetsyApi
import com.fintechhub.koin_mvvm.di.NetworkModule
import com.fintechhub.koin_mvvm.repository.TweetRepositoryImp
import com.fintechhub.koin_mvvm.viewModel.CategoryViewModel
import com.fintechhub.koin_mvvm.viewModel.DetailsView
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module
import retrofit2.Retrofit


val appModule = module {
    // Ensure that TweetsyApi is provided
    single { NetworkModule().provideRetrofit() } // or however you are providing Retrofit
    single { get<Retrofit>().create(TweetsyApi::class.java) } // provide TweetsyApi
    single<TweetRepositoryImp> { TweetRepositoryImp(get()) }
    // Register your ViewModels
    viewModel { CategoryViewModel(get()) }
    viewModel { (savedStateHandle: SavedStateHandle) -> DetailsView(get(), savedStateHandle) }
}