package pl.senordeveloper.roommoshienums.db

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

object FruitConverter {
    private val fruitAdapter: JsonAdapter<List<Fruit>> = Moshi.Builder()
        .build().adapter(Types.newParameterizedType(List::class.java, Fruit::class.java))

    @TypeConverter
    fun fromFruits(value: List<Fruit>): String = fruitAdapter.toJson(value).also {
        println("fromFruits: ${value.joinToString()} -> $it")
    }

    @TypeConverter
    fun toFruits(value: String): List<Fruit> = (fruitAdapter.fromJson(value) ?: emptyList()).also {
        println("toFruits: $value -> ${it.joinToString()}}")
    }
}