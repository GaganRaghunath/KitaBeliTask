package com.app.core.data.local.exception

sealed class SqlExceptions {
  class Failure(val message: String) : SqlExceptions()
}
