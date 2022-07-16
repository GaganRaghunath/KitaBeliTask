package com.app.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "order_history_item")
data class OrderHistoryItem(
  @PrimaryKey(autoGenerate = true) val id: Long,
  @ColumnInfo(name = "orderId") val orderId: Long,
  @ColumnInfo(name = "itemId") var itemId: String,
  @ColumnInfo(name = "title") var title: String,
  @ColumnInfo(name = "price") var price: Double,
  @ColumnInfo(name = "quantity") var quantity: Int,
  @ColumnInfo(name = "itemStatus") var itemStatus: String,
  @ColumnInfo(name = "thumbnail") var thumbnail: String,
)
