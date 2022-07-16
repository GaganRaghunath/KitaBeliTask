package com.app.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class OrderHistoryResponse(
  @SerializedName("status") var status: Status? = Status(),
  @SerializedName("data") var data: Data? = Data()
) {

  data class Status(
    @SerializedName("httpCode") var httpCode: String? = null,
    @SerializedName("success") var success: Boolean? = null,
    @SerializedName("message") var message: String? = null
  )

  data class Data(
    @SerializedName("totalPages") var totalPages: Int? = null,
    @SerializedName("totalItems") var totalItems: Int? = null,
    @SerializedName("ordersResponseDTO") var ordersResponseDTO: List<OrdersResponseDTO>? = null
  )

  data class OrdersResponseDTO(
    @SerializedName("orderItems") var orderItems: List<OrderItem>? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("totalAmount") var totalAmount: Int? = null,
    @SerializedName("payerEmail") var payerEmail: String? = null,
    @SerializedName("payerPhone") var payerPhone: String? = null,
    @SerializedName("quantity") var quantity: Int? = null,
    @SerializedName("shippingCost") var shippingCost: Int? = null,
    @SerializedName("discountAmount") var discountAmount: Int? = null,
    @SerializedName("orderId") var orderId: Int? = null,
    @SerializedName("userId") var userId: Int? = null,
    @SerializedName("paymentId") var paymentId: Int? = null,
    @SerializedName("paymentStatus") var paymentStatus: String? = null,
    @SerializedName("reason") var reason: String? = null,
    @SerializedName("paymentMode") var paymentMode: String? = null,
    @SerializedName("rating") var rating: Int? = null,
    @SerializedName("solidStarIcon") var solidStarIcon: String? = null,
    @SerializedName("createdAt") var createdAt: String? = null,
    @SerializedName("updatedAt") var updatedAt: String? = null
  )

  data class OrderItem(
    @SerializedName("itemId") var itemId: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("price") var price: Double? = null,
    @SerializedName("quantity") var quantity: Int? = null,
    @SerializedName("itemStatus") var itemStatus: String? = null,
    @SerializedName("thumbnail") var thumbnail: String? = null
  )

}