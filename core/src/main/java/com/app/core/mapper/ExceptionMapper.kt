package com.app.core.mapper

import com.app.core.data.local.exception.SqlExceptions
import com.app.core.data.remote.exceptions.NetworkExceptions
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception

class ExceptionMapper {

  val networkConnectionError = NetworkExceptions.NetworkConnection(IOException())

  fun mapToNetworkExceptions(exception: HttpException): NetworkExceptions {
    return when (exception.code()) {
      400 -> NetworkExceptions.BadRequest(exception)
      401 -> NetworkExceptions.UnAuthorized(exception)
      403 -> NetworkExceptions.BadRequest(exception)
      404 -> NetworkExceptions.NotFound(exception)
      408 -> NetworkExceptions.TimeOut(exception)
      500 -> NetworkExceptions.InternalServerError(exception)
      else -> NetworkExceptions.Failure("Unknown error occurred", exception)
    }
  }

  fun mapToSqlExceptions(exception: Exception): SqlExceptions {
    return SqlExceptions.Failure("${exception.message}")
  }
}