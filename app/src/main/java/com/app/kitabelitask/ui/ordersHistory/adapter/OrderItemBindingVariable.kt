package com.app.kitabelitask.ui.ordersHistory.adapter

import androidx.databinding.ObservableField
import com.app.core.data.remote.response.OrderHistoryResponse

class OrderItemBindingVariable(orderItem: OrderHistoryResponse.OrderItem) {

  val title = ObservableField<String>("")
  val price = ObservableField<Double>(0.0)
  val quantity = ObservableField<String>("")
  val thumbnailUrl = ObservableField<String>("")

  init {
    title.set(orderItem.title)
    price.set(orderItem.price)
    quantity.set(orderItem.quantity.toString())
    thumbnailUrl.set(orderItem.thumbnail)
  }
}