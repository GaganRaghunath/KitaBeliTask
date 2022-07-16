package com.app.core.data.remote.service

import com.app.core.data.remote.response.OrderHistoryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

  @GET("/api/v1/logistics/order")
  suspend fun getOrdersList(
    @Query("userId") userId: String,
    @Query("status") status: String,
    @Query("page") page: Int,
    @Query("size") size: Int
  ): OrderHistoryResponse

}