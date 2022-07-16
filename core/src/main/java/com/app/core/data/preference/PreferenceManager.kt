package com.app.core.data.preference

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class PreferenceManager @Inject constructor(
  @ApplicationContext context: Context
) : PreferenceHelper {

  private val sharedPreferences: SharedPreferences =
    context.getSharedPreferences("KitaBeliPreference", MODE_PRIVATE)

  override var userId: String
    get() = sharedPreferences.getString(PREF_USER_ID, "104913") ?: ""
    set(value) {
      sharedPreferences.edit().putString(PREF_USER_ID, value).apply()
    }

  companion object {
    const val PREF_USER_ID = "userId"
  }
}