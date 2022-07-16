package com.app.kitabelitask.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.app.kitabelitask.BR


abstract class BaseActivity<VM : ViewModel, B : ViewDataBinding> : AppCompatActivity() {

  abstract val layoutResId: Int
  abstract val mViewModel: VM

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = DataBindingUtil.setContentView<B>(this, layoutResId)
    binding.setVariable(BR.viewModel, mViewModel)
    initBinding(binding)
  }

  abstract fun initBinding(binding: B)
}