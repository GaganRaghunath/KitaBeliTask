package com.app.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "order_history")
data class OrderHistory(
  @PrimaryKey(autoGenerate = true) val id: Long,
  @ColumnInfo(name = "status") var status: String,
  @ColumnInfo(name = "totalAmount") var totalAmount: Int,
  @ColumnInfo(name = "payerEmail") var payerEmail: String,
  @ColumnInfo(name = "payerPhone") var payerPhone: String,
  @ColumnInfo(name = "quantity") var quantity: Int,
  @ColumnInfo(name = "shippingCost") var shippingCost: Int,
  @ColumnInfo(name = "discountAmount") var discountAmount: Int,
  @ColumnInfo(name = "orderId") var orderId: Int,
  @ColumnInfo(name = "userId") var userId: Int,
  @ColumnInfo(name = "paymentId") var paymentId: Int,
  @ColumnInfo(name = "paymentStatus") var paymentStatus: String,
  @ColumnInfo(name = "reason") var reason: String,
  @ColumnInfo(name = "paymentMode") var paymentMode: String,
  @ColumnInfo(name = "rating") var rating: Int,
  @ColumnInfo(name = "solidStarIcon") var solidStarIcon: String,
  @ColumnInfo(name = "createdAt") var createdAt: String,
  @ColumnInfo(name = "updatedAt") var updatedAt: String,
)
