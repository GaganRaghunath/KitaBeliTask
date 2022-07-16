package com.app.core.data.repository

import androidx.paging.PagingData
import com.app.core.data.remote.response.OrderHistoryResponse
import com.app.core.data.resource.Resource
import kotlinx.coroutines.flow.Flow

interface IOrderHistoryRepository {

  suspend fun getConfirmedOrderHistory(page: Int, size: Int): Flow<Resource<OrderHistoryResponse>>

  suspend fun getDispatchedOrderHistory(page: Int, size: Int): Flow<Resource<OrderHistoryResponse>>

  suspend fun getCompletedOrderHistory(page: Int, size: Int): Flow<Resource<OrderHistoryResponse>>

  suspend fun getCancelledOrderHistory(page: Int, size: Int): Flow<Resource<OrderHistoryResponse>>

  suspend fun getConfirmedOrderPagingData(): Flow<PagingData<OrderHistoryResponse.OrdersResponseDTO>>

  suspend fun getDispatchedOrderPagingData(): Flow<PagingData<OrderHistoryResponse.OrdersResponseDTO>>

  suspend fun getCompletedOrderPagingData(): Flow<PagingData<OrderHistoryResponse.OrdersResponseDTO>>

  suspend fun getCancelledOrderPagingData(): Flow<PagingData<OrderHistoryResponse.OrdersResponseDTO>>

  fun getUserId(): String
}