package com.app.core.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.core.data.local.dao.OrderHistoryDao
import com.app.core.data.local.dao.OrderHistoryItemDao
import com.app.core.data.local.entity.OrderHistory
import com.app.core.data.local.entity.OrderHistoryItem

@Database(
  entities = [
    OrderHistory::class,
    OrderHistoryItem::class,
  ],
  version = 1,
  exportSchema = false
)
abstract class RoomDB : RoomDatabase() {

  abstract fun orderHistoryDao(): OrderHistoryDao
  abstract fun orderHistoryItemDao(): OrderHistoryItemDao

  companion object {
    @Volatile
    private var INSTANCE: RoomDB? = null

    fun getDatabase(
      context: Context,
      databaseName: String,
    ): RoomDB {
      val tempInstance = INSTANCE
      if (tempInstance != null) {
        return tempInstance
      }

      synchronized(this) {
        val instance = Room.databaseBuilder(
          context.applicationContext,
          RoomDB::class.java,
          databaseName
        ).build()
        INSTANCE = instance
        return instance
      }
    }
  }
}