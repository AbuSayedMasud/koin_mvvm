package com.fintechhub.koin_mvvm

import androidx.lifecycle.SavedStateHandle
import com.fintechhub.koin_mvvm.api.TweetsyApi
import com.fintechhub.koin_mvvm.api.TweetsyApiImpl
import com.fintechhub.koin_mvvm.repository.TweetRepositoryImp
import com.fintechhub.koin_mvvm.viewModel.CategoryViewModel
import com.fintechhub.koin_mvvm.viewModel.DetailsView
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module


val appModule = module {
    // Ensure that TweetsyApi is provided
    single { HttpClientProvider.client }
    single<TweetsyApi> { TweetsyApiImpl(get()) }
    single<TweetRepositoryImp> { TweetRepositoryImp(get()) }
    // Register your ViewModels
    viewModel { CategoryViewModel(get()) }
    viewModel { (savedStateHandle: SavedStateHandle) -> DetailsView(get(), savedStateHandle) }
}