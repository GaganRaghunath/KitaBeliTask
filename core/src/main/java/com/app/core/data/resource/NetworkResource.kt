package com.app.core.data.resource

import com.app.core.data.remote.exceptions.NetworkExceptions

sealed class NetworkResource<out R> {
  data class Success<out T>(val data: T) : NetworkResource<T>()
  data class Error(val networkException: NetworkExceptions) : NetworkResource<Nothing>()
  object Empty : NetworkResource<Nothing>()
}