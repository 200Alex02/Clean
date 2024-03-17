package com.feature.domain.util

sealed class Resource <out T> {
    data class Success<out T>(val data : T? = null) : Resource<T>()
    data class Error(val errorMessage : String? = null) : Resource<Nothing>()
}