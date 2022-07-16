package com.app.kitabelitask.ui.ordersHistory.adapter

import com.app.core.data.remote.response.OrderHistoryResponse
import com.app.kitabelitask.BR
import com.app.kitabelitask.databinding.AdapterOrderItemBinding
import com.app.kitabelitask.ui.base.BaseViewHolder

class OrderItemViewHolder(private val _binding: AdapterOrderItemBinding) :
  BaseViewHolder(_binding.root) {

  override fun onBind(model: OrderHistoryResponse.OrderItem?) {
    model?.let {
      _binding.setVariable(BR.viewModel, OrderItemBindingVariable(it))
    }
  }
}