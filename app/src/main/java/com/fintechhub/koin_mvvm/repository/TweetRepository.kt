package com.fintechhub.koin_mvvm.repository

import android.util.Log
import com.fintechhub.koin_mvvm.api.TweetsyApi
import com.fintechhub.koin_mvvm.model.TweetyDataItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TweetRepositoryImp(private val tweetsyApi: TweetsyApi) {
    private val _categories = MutableStateFlow<List<String>>(emptyList())

    val category: StateFlow<List<String>>
        get() = _categories
    private val _tweety = MutableStateFlow<List<TweetyDataItem>>(emptyList())
    val tweety: StateFlow<List<TweetyDataItem>>
        get() = _tweety
    suspend fun getCategories() {
        val response = tweetsyApi.getCategories()
        if (response.body() != null && response.isSuccessful) {
            _categories.emit(response.body()!!)
        }
    }
    suspend fun getTweets(category: String) {
        val response = tweetsyApi.getTweetsy("tweets[?(@.category==\"$category\")]")
        if (response.body() != null && response.isSuccessful) {
            _tweety.emit(response.body()!!)
        }
    }
}