package com.app.kitabelitask.ui.ordersHistory.adapter

import androidx.databinding.ObservableField
import com.app.core.data.remote.response.OrderHistoryResponse

class OrderHistoryBindingVariable(ordersResponseDTO: OrderHistoryResponse.OrdersResponseDTO) {

  val date = ObservableField<String>("")
  val orderId = ObservableField<String>("")

  init {
    date.set(ordersResponseDTO.createdAt)
    orderId.set("${ordersResponseDTO.orderId}")
  }
}