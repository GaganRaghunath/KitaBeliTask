package com.app.core.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class OrderHistoryWithItems(
  @Embedded val orderHistory: OrderHistory,
  @Relation(
    parentColumn = "id",
    entityColumn = "orderId"
  )
  val orderHistoryItem: List<OrderHistoryItem>
)