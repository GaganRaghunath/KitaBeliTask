package com.app.core.data.resource

import com.app.core.data.remote.exceptions.NetworkExceptions

sealed class Resource<out R> {
  data class Success<out T>(val data: T) : Resource<T>()
  data class Error(val networkExceptions: NetworkExceptions) : Resource<Nothing>()
  object Empty : Resource<Nothing>()
}