package com.fintechhub.koin_mvvm.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

@Serializable
data class TweetyDataItem(
    val category: String,
    val text: String
)