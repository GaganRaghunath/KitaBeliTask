package com.app.core.mapper

import com.app.core.data.remote.response.OrderHistoryResponse
import com.app.core.models.OrderHistoryModel

object DataMapper {

  /*fun mapResponsesToModels(input: OrderHistoryResponse): OrderHistoryModel {
    val status = input.status?.let {
      OrderHistoryModel.Status(
        httpCode = it.httpCode ?: "",
        success = it.success ?: false,
        message = it.message ?: "",
      )
    } ?: OrderHistoryModel.Status()

    val data = input.data?.let {
      OrderHistoryModel.Data(
        totalPages = it.totalPages ?: 0,
        totalItems =  it.totalItems ?: 0,
        ordersResponseDTO = it.ordersResponseDTO,
      )
    } ?: OrderHistoryModel.Data()

    return OrderHistoryModel(
      status = status,
      data = data
    )
  }*/
}