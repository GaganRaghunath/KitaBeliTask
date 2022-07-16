package com.app.kitabelitask.app

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KitaBeliApp : MultiDexApplication() {

  override fun onCreate() {
    super.onCreate()
  }
}