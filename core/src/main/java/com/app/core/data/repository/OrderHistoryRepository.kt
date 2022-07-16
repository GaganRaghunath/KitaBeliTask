package com.app.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.app.core.data.pagingSource.CancelledPagingSource
import com.app.core.data.pagingSource.CompletedPagingSource
import com.app.core.data.pagingSource.ConfirmedPagingSource
import com.app.core.data.pagingSource.DispatchedPagingSource
import com.app.core.data.preference.PreferenceHelper
import com.app.core.data.remote.ApiDataSource
import com.app.core.data.remote.response.OrderHistoryResponse
import com.app.core.data.resource.NetworkResource
import com.app.core.data.resource.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class OrderHistoryRepository @Inject constructor(
  private val apiDataSource: ApiDataSource,
  private val preferenceHelper: PreferenceHelper,
  private val confirmedPagingSource: ConfirmedPagingSource,
  private val dispatchedPagingSource: DispatchedPagingSource,
  private val completedPagingSource: CompletedPagingSource,
  private val cancelledPagingSource: CancelledPagingSource,
) : IOrderHistoryRepository {

  override suspend fun getConfirmedOrderHistory(
    page: Int,
    size: Int
  ): Flow<Resource<OrderHistoryResponse>> {
    return flow {
      emitAll(
        apiDataSource.getOrdersList(getUserId(), "CONFIRMED", page, size)
          .map {
            when (it) {
              NetworkResource.Empty -> Resource.Empty
              is NetworkResource.Error -> Resource.Error(it.networkException)
              is NetworkResource.Success -> Resource.Success(it.data)
            }
          }
      )
    }.flowOn(Dispatchers.IO)
  }

  override suspend fun getDispatchedOrderHistory(
    page: Int,
    size: Int
  ): Flow<Resource<OrderHistoryResponse>> {
    return flow {
      emitAll(
        apiDataSource.getOrdersList(getUserId(), "DISPATCHED", page, size)
          .map {
            when (it) {
              NetworkResource.Empty -> Resource.Empty
              is NetworkResource.Error -> Resource.Error(it.networkException)
              is NetworkResource.Success -> Resource.Success(it.data)
            }
          }
      )
    }.flowOn(Dispatchers.IO)
  }

  override suspend fun getCompletedOrderHistory(
    page: Int,
    size: Int
  ): Flow<Resource<OrderHistoryResponse>> {
    return flow {
      emitAll(
        apiDataSource.getOrdersList(getUserId(), "COMPLETED", page, size)
          .map {
            when (it) {
              NetworkResource.Empty -> Resource.Empty
              is NetworkResource.Error -> Resource.Error(it.networkException)
              is NetworkResource.Success -> Resource.Success(it.data)
            }
          }
      )
    }.flowOn(Dispatchers.IO)
  }

  override suspend fun getCancelledOrderHistory(
    page: Int,
    size: Int
  ): Flow<Resource<OrderHistoryResponse>> {
    return flow {
      emitAll(
        apiDataSource.getOrdersList(getUserId(), "CANCELLED", page, size)
          .map {
            when (it) {
              NetworkResource.Empty -> Resource.Empty
              is NetworkResource.Error -> Resource.Error(it.networkException)
              is NetworkResource.Success -> Resource.Success(it.data)
            }
          }
      )
    }.flowOn(Dispatchers.IO)
  }

  override suspend fun getConfirmedOrderPagingData(): Flow<PagingData<OrderHistoryResponse.OrdersResponseDTO>> {
    return Pager(
      config = PagingConfig(
        pageSize = PAGE_ITEM_COUNT,
        maxSize = 200,
        enablePlaceholders = false
      ),
      pagingSourceFactory = {
        confirmedPagingSource.apply { userId = getUserId() }
      }
    ).flow.flowOn(Dispatchers.IO)
  }

  override suspend fun getDispatchedOrderPagingData(): Flow<PagingData<OrderHistoryResponse.OrdersResponseDTO>> {
    return Pager(
      config = PagingConfig(
        pageSize = PAGE_ITEM_COUNT,
        maxSize = 200,
        enablePlaceholders = false
      ),
      pagingSourceFactory = {
        dispatchedPagingSource.apply { userId = getUserId() }
      }
    ).flow
  }

  override suspend fun getCompletedOrderPagingData(): Flow<PagingData<OrderHistoryResponse.OrdersResponseDTO>> {
    return Pager(
      config = PagingConfig(
        pageSize = PAGE_ITEM_COUNT,
        maxSize = 200,
        enablePlaceholders = false
      ),
      pagingSourceFactory = {
        completedPagingSource.apply { userId = getUserId() }
      }
    ).flow
  }

  override suspend fun getCancelledOrderPagingData(): Flow<PagingData<OrderHistoryResponse.OrdersResponseDTO>> {
    return Pager(
      config = PagingConfig(
        pageSize = PAGE_ITEM_COUNT,
        maxSize = 200,
        enablePlaceholders = false
      ),
      pagingSourceFactory = {
        cancelledPagingSource.apply { userId = getUserId() }
      }
    ).flow
  }

  override fun getUserId(): String {
    return preferenceHelper.userId
  }

  companion object {
    const val START_PAGE_POSITION = 0
    const val PAGE_ITEM_COUNT = 20
  }
}