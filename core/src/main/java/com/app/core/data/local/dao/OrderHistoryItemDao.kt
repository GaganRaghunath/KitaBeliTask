package com.app.core.data.local.dao

import androidx.room.*
import com.app.core.data.local.entity.OrderHistoryItem

@Dao
interface OrderHistoryItemDao {

  @Query("DELETE FROM order_history_item")
  suspend fun clearAll()

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertAll(orderHistoryItem: List<OrderHistoryItem>)

  @Query("SELECT * FROM order_history_item")
  suspend fun getAll(): List<OrderHistoryItem>

  @Update
  suspend fun updateOrderHistoryItem(orderHistoryItem: List<OrderHistoryItem>)

  @Delete
  fun deleteOrderHistoryItem(orderHistoryItem: List<OrderHistoryItem>)
}