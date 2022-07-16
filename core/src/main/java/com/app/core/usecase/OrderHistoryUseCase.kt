package com.app.core.usecase

import com.app.core.data.remote.response.OrderHistoryResponse
import com.app.core.data.resource.Resource
import kotlinx.coroutines.flow.Flow

interface OrderHistoryUseCase {

  suspend fun getAllConfirmedOrders(page: Int, size: Int): Flow<Resource<OrderHistoryResponse>>

  suspend fun getAllDispatchedOrders(page: Int, size: Int): Flow<Resource<OrderHistoryResponse>>

  suspend fun getAllCompletedOrders(page: Int, size: Int): Flow<Resource<OrderHistoryResponse>>

  suspend fun getAllCancelledOrders(page: Int, size: Int): Flow<Resource<OrderHistoryResponse>>
}