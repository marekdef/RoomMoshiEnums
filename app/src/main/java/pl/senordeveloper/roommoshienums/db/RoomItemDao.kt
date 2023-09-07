package pl.senordeveloper.roommoshienums.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomItemDao {
    @Query("SELECT * FROM RoomItem")
    fun getAll(): Flow<List<RoomItem>>

    @Insert
    fun insertAll(vararg items: RoomItem)
}