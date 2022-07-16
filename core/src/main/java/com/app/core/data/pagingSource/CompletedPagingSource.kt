package com.app.core.data.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.app.core.data.remote.response.OrderHistoryResponse
import com.app.core.data.remote.response.OrderHistoryResponse.OrdersResponseDTO
import com.app.core.data.remote.service.RetrofitService
import com.app.core.data.repository.OrderHistoryRepository
import com.app.core.data.resource.Resource
import com.app.core.usecase.OrderHistoryUseCase
import javax.inject.Inject

class CompletedPagingSource @Inject constructor(private val retrofitService: RetrofitService) :
  PagingSource<Int, OrdersResponseDTO>() {


  private var eventCallback: ((Resource<OrderHistoryResponse>) -> Unit)? = null
  var userId: String = ""

  override fun getRefreshKey(state: PagingState<Int, OrdersResponseDTO>): Int? {
    return state.anchorPosition?.let { anchorPosition ->
      val anchorPage = state.closestPageToPosition(anchorPosition)
      anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
    }
  }

  override suspend fun load(params: LoadParams<Int>): LoadResult<Int, OrdersResponseDTO> {
    val nextPageNumber = params.key ?: OrderHistoryRepository.START_PAGE_POSITION
    return try {
      val response = retrofitService.getOrdersList(
        userId,
        "COMPLETED",
        nextPageNumber,
        OrderHistoryRepository.PAGE_ITEM_COUNT
      )
      val dataList = response.data?.ordersResponseDTO ?: emptyList()
      LoadResult.Page(
        data = dataList,
        prevKey = if (nextPageNumber == OrderHistoryRepository.START_PAGE_POSITION) null else nextPageNumber.minus(
          1
        ),
        nextKey = if (dataList.isEmpty()) null else nextPageNumber.plus(1)
      )
    } catch (exception: Exception) {
      return LoadResult.Error(exception)
    }
  }

  fun setCallback(callback: ((Resource<OrderHistoryResponse>) -> Unit)) {
    eventCallback = callback
  }
}