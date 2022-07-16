package com.app.kitabelitask.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.app.core.data.remote.response.OrderHistoryResponse

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

  abstract fun onBind(model: OrderHistoryResponse.OrderItem?)
}