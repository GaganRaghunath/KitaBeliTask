package com.app.core.data.resource

import com.app.core.data.local.exception.SqlExceptions

sealed class LocalResource<out R> {
  data class Success<out T>(val data: T) : LocalResource<T>()
  data class Error(val errorMessage: SqlExceptions) : LocalResource<Nothing>()
  object Empty : LocalResource<Nothing>()
}