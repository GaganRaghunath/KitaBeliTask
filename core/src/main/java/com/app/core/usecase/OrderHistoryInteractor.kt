package com.app.core.usecase

import com.app.core.data.remote.response.OrderHistoryResponse
import com.app.core.data.repository.OrderHistoryRepository
import com.app.core.data.resource.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrderHistoryInteractor @Inject constructor(
  private val orderHistoryRepository: OrderHistoryRepository
) : OrderHistoryUseCase {

  override suspend fun getAllConfirmedOrders(
    page: Int,
    size: Int
  ): Flow<Resource<OrderHistoryResponse>> {
    return orderHistoryRepository.getConfirmedOrderHistory(page, size)
  }

  override suspend fun getAllDispatchedOrders(
    page: Int,
    size: Int
  ): Flow<Resource<OrderHistoryResponse>> {
    return orderHistoryRepository.getDispatchedOrderHistory(page, size)
  }

  override suspend fun getAllCompletedOrders(
    page: Int,
    size: Int
  ): Flow<Resource<OrderHistoryResponse>> {
    return orderHistoryRepository.getCompletedOrderHistory(page, size)
  }

  override suspend fun getAllCancelledOrders(
    page: Int,
    size: Int
  ): Flow<Resource<OrderHistoryResponse>> {
    return orderHistoryRepository.getCancelledOrderHistory(page, size)
  }

}