package com.app.kitabelitask.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.app.kitabelitask.R
import com.bumptech.glide.Glide
import java.text.DecimalFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object BindingAdapter {

  @JvmStatic
  @BindingAdapter("loadImageUrl")
  fun loadImageUrl(imgView: ImageView, url: String?) {
    if (url == null || url.isEmpty() || url.isBlank()) {
      Glide.with(imgView.context).load(R.drawable.placeholder).into(imgView)
    } else {
      Glide.with(imgView.context).load(url).into(imgView)
    }
  }

  @JvmStatic
  @BindingAdapter("orderDate")
  fun orderDate(textView: TextView, date: String?) {
    val inputDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    val finalDateFormat = SimpleDateFormat("EEE, DD MMM yyyy", Locale.getDefault())
    date?.let {
      try {
        val dateObj = inputDateFormat.parse(it)
        if (dateObj != null) {
          textView.text = finalDateFormat.format(dateObj)
        }
      } catch (e: ParseException) {
        textView.text = finalDateFormat.format("Invalid")
      }
    }
  }

  @JvmStatic
  @BindingAdapter("formatPrice")
  fun formatPrice(textView: TextView, price: Double) {
    val formattedPrice = DecimalFormat("##,##,##0.00#").format(price)
    textView.text = "Rp $formattedPrice"
  }
}