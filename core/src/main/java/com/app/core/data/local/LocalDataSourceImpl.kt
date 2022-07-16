package com.app.core.data.local

import com.app.core.data.local.db.RoomDB
import com.app.core.data.local.entity.OrderHistoryWithItems
import com.app.core.data.resource.LocalResource
import com.app.core.mapper.ExceptionMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
  private val roomDB: RoomDB
) : LocalDataSource {

  override suspend fun getOrdersList(
    status: String,
    page: Int,
    size: Int
  ): Flow<LocalResource<List<OrderHistoryWithItems>>> {
    return flow {
      try {
        val response = roomDB.orderHistoryDao().getOrderHistoryWithItems(status, page, size)
        if (response.isEmpty()) {
          emit(LocalResource.Empty)
        } else {
          emit(LocalResource.Success(response))
        }
      } catch (e: Exception) {
        val networkException = ExceptionMapper().mapToSqlExceptions(e)
        emit(LocalResource.Error(networkException))
      }
    }
  }
}