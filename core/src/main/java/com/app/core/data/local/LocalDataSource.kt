package com.app.core.data.local

import com.app.core.data.local.entity.OrderHistoryWithItems
import com.app.core.data.remote.response.OrderHistoryResponse
import com.app.core.data.resource.LocalResource
import com.app.core.data.resource.NetworkResource
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

  suspend fun getOrdersList(
    status: String,
    page: Int,
    size: Int,
  ): Flow<LocalResource<List<OrderHistoryWithItems>>>
}