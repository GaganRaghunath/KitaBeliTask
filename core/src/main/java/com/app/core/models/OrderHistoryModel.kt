package com.app.core.models

import com.google.gson.annotations.SerializedName

data class OrderHistoryModel(
  @SerializedName("status") val status: Status,
  @SerializedName("data") val data: Data,
) {

  data class Status(
    @SerializedName("httpCode") val httpCode: String = "",
    @SerializedName("success") val success: Boolean = false,
    @SerializedName("message") val message: String = ""
  )

  data class Data(
    @SerializedName("totalPages") val totalPages: Int = 0,
    @SerializedName("totalItems") val totalItems: Int = 0,
    @SerializedName("ordersResponseDTO") val ordersResponseDTO: List<OrdersResponseDTO> = emptyList()
  )

  data class OrdersResponseDTO(
    @SerializedName("orderItems") val orderItems: List<OrderItem> = emptyList(),
    @SerializedName("status") val status: String = "",
    @SerializedName("totalAmount") val totalAmount: Int = 0,
    @SerializedName("payerEmail") val payerEmail: String = "",
    @SerializedName("payerPhone") val payerPhone: String = "",
    @SerializedName("quantity") val quantity: Int = 0,
    @SerializedName("shippingCost") val shippingCost: Int = 0,
    @SerializedName("discountAmount") val discountAmount: Int = 0,
    @SerializedName("orderId") val orderId: Int = 0,
    @SerializedName("userId") val userId: Int = 0,
    @SerializedName("paymentId") val paymentId: Int = 0,
    @SerializedName("paymentStatus") val paymentStatus: String = "",
    @SerializedName("reason") val reason: String = "",
    @SerializedName("paymentMode") val paymentMode: String = "",
    @SerializedName("rating") val rating: Int = 0,
    @SerializedName("solidStarIcon") val solidStarIcon: String = "",
    @SerializedName("createdAt") val createdAt: String = "",
    @SerializedName("updatedAt") val updatedAt: String = ""
  )

  data class OrderItem(
    @SerializedName("itemId") val itemId: String = "",
    @SerializedName("title") val title: String = "",
    @SerializedName("price") val price: Double = 0.0,
    @SerializedName("quantity") val quantity: Int = 0,
    @SerializedName("itemStatus") val itemStatus: String = "",
    @SerializedName("thumbnail") val thumbnail: String = ""
  )
}