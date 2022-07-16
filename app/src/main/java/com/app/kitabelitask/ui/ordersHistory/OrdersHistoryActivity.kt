package com.app.kitabelitask.ui.ordersHistory

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.app.kitabelitask.R
import com.app.kitabelitask.databinding.ActivityMainBinding
import com.app.kitabelitask.ui.base.BaseActivity
import com.app.kitabelitask.ui.ordersHistory.cancelled.CancelledFragment
import com.app.kitabelitask.ui.ordersHistory.completed.CompletedFragment
import com.app.kitabelitask.ui.ordersHistory.confirmed.ConfirmedFragment
import com.app.kitabelitask.ui.ordersHistory.dispatched.DispatchedFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OrdersHistoryActivity : BaseActivity<OrdersHistoryViewModel, ActivityMainBinding>() {

  private lateinit var _binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initViewPager()

    setSupportActionBar(_binding.toolbar)
    supportActionBar?.let {
      it.setDisplayHomeAsUpEnabled(true)
      it.setDisplayShowHomeEnabled(true)
    }
  }


  private fun initViewPager() {
    _binding.ordersPager.offscreenPageLimit = PAGE_COUNT
    _binding.ordersPager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
      override fun getCount(): Int = PAGE_COUNT

      override fun getItem(position: Int): Fragment {
        return when (position) {
          0 -> ConfirmedFragment()
          1 -> DispatchedFragment()
          2 -> CompletedFragment()
          3 -> CancelledFragment()
          else -> ConfirmedFragment()
        }
      }

      override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
          0 -> getString(R.string.confirmed).uppercase()
          1 -> getString(R.string.dispatched).uppercase()
          2 -> getString(R.string.completed).uppercase()
          3 -> getString(R.string.cancelled).uppercase()
          else -> null
        }
      }
    }
    _binding.tabLayout.setupWithViewPager(_binding.ordersPager, true)
  }

  override fun onSupportNavigateUp(): Boolean {
    onBackPressed()
    return true
  }

  override val layoutResId: Int = R.layout.activity_main
  override val mViewModel: OrdersHistoryViewModel by viewModels()

  override fun initBinding(binding: ActivityMainBinding) {
    _binding = binding
  }

  companion object {
    private const val PAGE_COUNT = 4
  }
}