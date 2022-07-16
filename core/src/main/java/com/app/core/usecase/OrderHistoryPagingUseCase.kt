package com.app.core.usecase

import androidx.paging.PagingData
import com.app.core.data.remote.response.OrderHistoryResponse
import com.app.core.data.resource.Resource
import kotlinx.coroutines.flow.Flow

interface OrderHistoryPagingUseCase {

  suspend fun getConfirmedOrderPagingData(): Flow<PagingData<OrderHistoryResponse.OrdersResponseDTO>>

  suspend fun getDispatchedOrderPagingData(): Flow<PagingData<OrderHistoryResponse.OrdersResponseDTO>>

  suspend fun getCompletedOrderPagingData(): Flow<PagingData<OrderHistoryResponse.OrdersResponseDTO>>

  suspend fun getCancelledOrderPagingData(): Flow<PagingData<OrderHistoryResponse.OrdersResponseDTO>>
}