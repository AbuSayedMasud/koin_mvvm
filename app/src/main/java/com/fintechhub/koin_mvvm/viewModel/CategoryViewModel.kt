package com.fintechhub.koin_mvvm.viewModel

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fintechhub.koin_mvvm.repository.TweetRepositoryImp
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CategoryViewModel(private val repository: TweetRepositoryImp) : ViewModel() {
    val categories: StateFlow<List<String>>
        get() = repository.category

    init {
        viewModelScope.launch {
            repository.getCategories()
        }
    }
}