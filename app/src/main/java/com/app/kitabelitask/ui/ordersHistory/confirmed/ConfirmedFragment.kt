package com.app.kitabelitask.ui.ordersHistory.confirmed

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.app.kitabelitask.BR
import com.app.kitabelitask.R
import com.app.kitabelitask.databinding.FragmentOrdersListContainerBinding
import com.app.kitabelitask.ui.base.BaseFragment
import com.app.kitabelitask.ui.ordersHistory.OrdersHistoryViewModel
import com.app.kitabelitask.ui.ordersHistory.adapter.OrdersListItemAdapter
import kotlinx.coroutines.launch

class ConfirmedFragment :
  BaseFragment<OrdersHistoryViewModel, FragmentOrdersListContainerBinding>() {

  private lateinit var _binding: FragmentOrdersListContainerBinding

  override fun onAttach(context: Context) {
    super.onAttach(context)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentOrdersListContainerBinding.inflate(inflater, container, false)
    _binding.setVariable(BR.viewModel, mViewModel)
    return _binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val adapter = OrdersListItemAdapter()
    _binding.ordersRv.adapter = adapter

    lifecycleScope.launch {
      mViewModel.getConfirmedOrderPagingData().observe(viewLifecycleOwner) {
        adapter.submitData(viewLifecycleOwner.lifecycle, it)
      }
    }
  }


  override val layoutResId: Int
    get() = R.layout.fragment_orders_list_container
  override val mViewModel: OrdersHistoryViewModel by activityViewModels()

  override fun initBinding(binding: FragmentOrdersListContainerBinding) {
    _binding = binding
  }
}