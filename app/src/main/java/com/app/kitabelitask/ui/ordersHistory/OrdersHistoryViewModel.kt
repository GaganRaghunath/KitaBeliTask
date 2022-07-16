package com.app.kitabelitask.ui.ordersHistory

import androidx.databinding.ObservableField
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.app.core.data.remote.response.OrderHistoryResponse
import com.app.core.usecase.OrderHistoryPagingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

@HiltViewModel
class OrdersHistoryViewModel @Inject constructor(
  private val useCase: OrderHistoryPagingUseCase
) : ViewModel() {

  val showProgress = ObservableField(true)

  suspend fun getConfirmedOrderPagingData(): LiveData<PagingData<OrderHistoryResponse.OrdersResponseDTO>> {
    return useCase.getConfirmedOrderPagingData()
      .cachedIn(viewModelScope)
      .asLiveData()
  }

  suspend fun getDispatchedOrderPagingData(): LiveData<PagingData<OrderHistoryResponse.OrdersResponseDTO>> {
    return useCase.getDispatchedOrderPagingData()
      .cachedIn(viewModelScope)
      .asLiveData()
  }

  suspend fun getCompletedOrderPagingData(): LiveData<PagingData<OrderHistoryResponse.OrdersResponseDTO>> {
    return useCase.getCompletedOrderPagingData()
      .cachedIn(viewModelScope)
      .asLiveData()
  }

  suspend fun getCancelledOrderPagingData(): LiveData<PagingData<OrderHistoryResponse.OrdersResponseDTO>> {
    return useCase.getCancelledOrderPagingData()
      .cachedIn(viewModelScope)
      .asLiveData()
  }
}