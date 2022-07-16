package com.app.core.data.local.dao

import androidx.room.*
import com.app.core.data.local.entity.OrderHistory
import com.app.core.data.local.entity.OrderHistoryWithItems

@Dao
interface OrderHistoryDao {

  @Query("DELETE FROM order_history")
  suspend fun clearAll()

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertAll(orderHistory: List<OrderHistory>)

  @Query("SELECT * FROM order_history WHERE status LIKE :status LIMIT :limit OFFSET :offset")
  suspend fun getAll(status: String, limit: Int, offset: Int): List<OrderHistory>

  @Update
  suspend fun updateOrderHistory(orderHistory: List<OrderHistory>)

  @Delete
  fun deleteOrderHistory(orderHistory: List<OrderHistory>)

  @Transaction
  @Query("SELECT * FROM order_history WHERE status LIKE :status LIMIT :limit OFFSET :offset")
  fun getOrderHistoryWithItems(status: String, limit: Int, offset: Int): List<OrderHistoryWithItems>
}