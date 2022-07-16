package com.app.core.data.remote

import com.app.core.data.remote.response.OrderHistoryResponse
import com.app.core.data.resource.NetworkResource
import kotlinx.coroutines.flow.Flow

interface ApiDataSource {

  suspend fun getOrdersList(
    userId: String,
    status: String,
    page: Int,
    size: Int,
  ): Flow<NetworkResource<OrderHistoryResponse>>
}