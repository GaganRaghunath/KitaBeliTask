package com.app.core.usecase

import androidx.paging.PagingData
import com.app.core.data.remote.response.OrderHistoryResponse
import com.app.core.data.repository.OrderHistoryRepository
import com.app.core.data.resource.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrderHistoryPagingInteractor @Inject constructor(
  private val orderHistoryRepository: OrderHistoryRepository
) : OrderHistoryPagingUseCase {

  override suspend fun getConfirmedOrderPagingData(): Flow<PagingData<OrderHistoryResponse.OrdersResponseDTO>> {
    return orderHistoryRepository.getConfirmedOrderPagingData()
  }

  override suspend fun getDispatchedOrderPagingData(): Flow<PagingData<OrderHistoryResponse.OrdersResponseDTO>> {
    return orderHistoryRepository.getDispatchedOrderPagingData()
  }

  override suspend fun getCompletedOrderPagingData(): Flow<PagingData<OrderHistoryResponse.OrdersResponseDTO>> {
    return orderHistoryRepository.getCompletedOrderPagingData()
  }

  override suspend fun getCancelledOrderPagingData(): Flow<PagingData<OrderHistoryResponse.OrdersResponseDTO>> {
    return orderHistoryRepository.getCancelledOrderPagingData()
  }

}