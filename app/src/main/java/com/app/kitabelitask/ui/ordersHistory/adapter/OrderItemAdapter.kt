package com.app.kitabelitask.ui.ordersHistory.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.core.data.remote.response.OrderHistoryResponse
import com.app.kitabelitask.databinding.AdapterOrderItemBinding
import com.app.kitabelitask.ui.base.BaseViewHolder

abstract class OrderItemAdapter<VH : BaseViewHolder> : RecyclerView.Adapter<VH>() {

  private val dataList: ArrayList<OrderHistoryResponse.OrderItem> = arrayListOf(
    OrderHistoryResponse.OrderItem(
      itemId = "12345",
      title = "GOOD DEAL ALPUKAT MENTEGA SEDANG 500GR",
      price = 18.000,
      quantity = 1999,
      itemStatus = "",
      thumbnail = "https://cdn.pixabay.com/photo/2017/06/10/07/10/database-2389207_960_720.png",
    ),
  )

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
    val inflater = LayoutInflater.from(parent.context)
    val binding = AdapterOrderItemBinding.inflate(inflater, parent, false)
    return createViewHolderInstance(binding)
  }

  abstract fun createViewHolderInstance(binding: AdapterOrderItemBinding): VH

  override fun onBindViewHolder(holder: VH, position: Int) {
    holder.onBind(dataList[0])
  }

  override fun getItemCount(): Int {
    return 2
  }
}