package com.fintechhub.koin_mvvm.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fintechhub.koin_mvvm.model.TweetyDataItem
import com.fintechhub.koin_mvvm.repository.TweetRepositoryImp
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
class DetailsView(
    private val repository: TweetRepositoryImp,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val details: StateFlow<List<TweetyDataItem>>
        get() = repository.tweety

    init {
        viewModelScope.launch {
            // Retrieve the category from the SavedStateHandle
            val category = savedStateHandle.get<String>("message") ?: "technology"
            repository.getTweets(category)
        }
    }
}
