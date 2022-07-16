package com.app.core.data.remote.exceptions

sealed class NetworkExceptions(throwable: Throwable) {
  class NetworkConnection(val throwable: Throwable) : NetworkExceptions(throwable)
  class BadRequest(val throwable: Throwable) : NetworkExceptions(throwable)
  class UnAuthorized(val throwable: Throwable) : NetworkExceptions(throwable)
  class NotFound(val throwable: Throwable) : NetworkExceptions(throwable)
  class TimeOut(val throwable: Throwable) : NetworkExceptions(throwable)
  class InternalServerError(val throwable: Throwable) : NetworkExceptions(throwable)
  class Failure(val message: String, val throwable: Throwable) : NetworkExceptions(throwable)
}
