package com.learn.countriesapplication.utils

sealed class State<out R> {

    data class Success<out T>(val data: T) : State<T>()
    data class Error(val exception: Exception) : State<Nothing>()
    object Loading : State<Nothing>()
}