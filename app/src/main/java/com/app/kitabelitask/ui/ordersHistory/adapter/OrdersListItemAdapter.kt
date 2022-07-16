package com.app.kitabelitask.ui.ordersHistory.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.core.data.remote.response.OrderHistoryResponse.OrdersResponseDTO
import com.app.kitabelitask.databinding.AdapterOrderItemBinding
import com.app.kitabelitask.databinding.AdapterOrderListItemBinding

class OrdersListItemAdapter :
  PagingDataAdapter<OrdersResponseDTO, OrdersListItemAdapter.OrdersListItemViewHolder>(
    ORDER_COMPARATOR
  ) {

  private val viewPool: RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool()

  inner class OrdersListItemViewHolder(private val _binding: AdapterOrderListItemBinding) :
    RecyclerView.ViewHolder(_binding.root) {

    fun onBind(model: OrdersResponseDTO?) {
      model?.let {
        _binding.setVariable(BR.viewModel, OrderHistoryBindingVariable(it))
        when {
          it.status.equals("CONFIRMED", true) -> {
            _binding.orderItemRv.adapter = object : OrderItemAdapter<OrderItemViewHolder>() {
              override fun createViewHolderInstance(binding: AdapterOrderItemBinding): OrderItemViewHolder {
                return OrderItemViewHolder(binding)
              }
            }
          }
          it.status.equals("DISPATCHED", true) -> {
            _binding.orderItemRv.adapter = object : OrderItemAdapter<OrderItemStatusViewHolder>() {
              override fun createViewHolderInstance(binding: AdapterOrderItemBinding): OrderItemStatusViewHolder {
                return OrderItemStatusViewHolder(binding)
              }
            }
          }
          it.status.equals("COMPLETED", true) -> {
            _binding.orderItemRv.adapter = object : OrderItemAdapter<OrderItemCompletedViewHolder>() {
              override fun createViewHolderInstance(binding: AdapterOrderItemBinding): OrderItemCompletedViewHolder {
                return OrderItemCompletedViewHolder(binding)
              }
            }
          }
          it.status.equals("CANCELLED", true) -> {
            _binding.orderItemRv.adapter =
              object : OrderItemAdapter<OrderItemCancelledViewHolder>() {
                override fun createViewHolderInstance(binding: AdapterOrderItemBinding): OrderItemCancelledViewHolder {
                  return OrderItemCancelledViewHolder(binding)
                }
              }
          }
        }
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersListItemViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val binding = AdapterOrderListItemBinding.inflate(inflater, parent, false)
    binding.orderItemRv.setRecycledViewPool(viewPool)
    return OrdersListItemViewHolder(binding)
  }

  override fun onBindViewHolder(holder: OrdersListItemViewHolder, position: Int) {
    holder.onBind(getItem(position))
  }

  companion object {
    val ORDER_COMPARATOR = object : DiffUtil.ItemCallback<OrdersResponseDTO>() {
      override fun areItemsTheSame(
        oldItem: OrdersResponseDTO,
        newItem: OrdersResponseDTO
      ): Boolean {
        return oldItem.orderId?.equals(newItem.orderId) ?: false
      }

      override fun areContentsTheSame(
        oldItem: OrdersResponseDTO,
        newItem: OrdersResponseDTO
      ): Boolean {
        return oldItem == newItem
      }
    }
  }
}