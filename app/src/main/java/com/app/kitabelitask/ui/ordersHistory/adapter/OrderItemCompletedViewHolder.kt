package com.app.kitabelitask.ui.ordersHistory.adapter

import android.view.View
import androidx.core.content.ContextCompat
import com.app.core.data.remote.response.OrderHistoryResponse
import com.app.kitabelitask.BR
import com.app.kitabelitask.R
import com.app.kitabelitask.databinding.AdapterOrderItemBinding
import com.app.kitabelitask.ui.base.BaseViewHolder


class OrderItemCompletedViewHolder(private val _binding: AdapterOrderItemBinding) :
  BaseViewHolder(_binding.root) {

  override fun onBind(model: OrderHistoryResponse.OrderItem?) {
    model?.let {
      _binding.setVariable(BR.viewModel, OrderItemBindingVariable(it))
    }
    _binding.statusTv.text = "Produk terkirim"
    _binding.statusTv.setTextColor(
      ContextCompat.getColor(_binding.root.context, R.color.colorCompleted)
    )
    _binding.statusTv.visibility = View.VISIBLE
  }
}