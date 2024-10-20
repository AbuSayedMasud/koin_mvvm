package com.fintechhub.koin_mvvm.api

import com.fintechhub.koin_mvvm.model.TweetyDataItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface TweetsyApi {
    suspend fun getTweetsy(category: String): List<TweetyDataItem>
    suspend fun getCategories(): List<String>
}

class TweetsyApiImpl(private val client: HttpClient) : TweetsyApi {

    override suspend fun getTweetsy(category: String): List<TweetyDataItem> {
        return withContext(Dispatchers.IO) {
            client.get("https://api.jsonbin.io/v3/b/670e009ead19ca34f8b8b14b?meta=false") {
                header("X-JSON-Path", category)
            }.body()
        }
    }

    override suspend fun getCategories(): List<String> {
        return withContext(Dispatchers.IO) {
            client.get("https://api.jsonbin.io/v3/b/670e009ead19ca34f8b8b14b?meta=false") {
                header("X-JSON-Path", "tweets..category")
            }.body()
        }
    }
}
