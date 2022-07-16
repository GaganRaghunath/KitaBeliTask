package com.app.kitabelitask.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.app.kitabelitask.BR

abstract class BaseFragment<VM : ViewModel, B : ViewDataBinding> : Fragment() {

  abstract val layoutResId: Int
  abstract val mViewModel: VM

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val binding = DataBindingUtil.inflate<B>(inflater, layoutResId, container, false)
    binding.setVariable(BR.viewModel, mViewModel)
    initBinding(binding)
    return binding.root
  }

  abstract fun initBinding(binding: B)

  fun showMessage(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
  }
}