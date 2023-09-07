package pl.senordeveloper.roommoshienums.db

import androidx.room.Database
import androidx.room.TypeConverters

@Database(entities = [RoomItem::class],
    version = 9,
    exportSchema = false)
@TypeConverters(FruitConverter::class, VegetableConverter::class, VegetableWrapConverter::class)
abstract class RoomDatabase : androidx.room.RoomDatabase() {
    abstract fun roomItems(): RoomItemDao
}