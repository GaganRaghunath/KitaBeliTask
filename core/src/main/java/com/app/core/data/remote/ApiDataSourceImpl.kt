package com.app.core.data.remote

import com.app.core.data.remote.response.OrderHistoryResponse
import com.app.core.data.remote.service.RetrofitService
import com.app.core.data.resource.NetworkResource
import com.app.core.data.resource.Resource
import com.app.core.mapper.ExceptionMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ApiDataSourceImpl @Inject constructor(
  private val retrofitService: RetrofitService
) : ApiDataSource {

  override suspend fun getOrdersList(
    userId: String,
    status: String,
    page: Int,
    size: Int
  ): Flow<NetworkResource<OrderHistoryResponse>> {
    return flow {
      try {
        val response = retrofitService.getOrdersList(userId, status, page, size)
        if (response.status == null) {
          emit(NetworkResource.Empty)
        } else {
          if (response.status?.success == true) {
            emit(NetworkResource.Success(response))
          } else {
            emit(NetworkResource.Empty)
          }
        }
      } catch (e: HttpException) {
        val networkException = ExceptionMapper().mapToNetworkExceptions(e)
        emit(NetworkResource.Error(networkException))
      } catch (e: IOException) {
        val networkException = ExceptionMapper().networkConnectionError
        emit(NetworkResource.Error(networkException))
      }
    }
  }
}