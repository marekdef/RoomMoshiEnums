package pl.senordeveloper.roommoshienums.db

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

object VegetableConverter {
    private val vegetableAdapter: JsonAdapter<List<Vegetable>> = Moshi.Builder()
        .build().adapter(Types.newParameterizedType(List::class.java, Vegetable::class.java))

    @TypeConverter
    fun fromVegetables(value: List<Vegetable>): String = vegetableAdapter.toJson(value).also {
        println("fromVegetables: ${value.joinToString()} -> $it")
    }

    @TypeConverter
    fun toVegetables(value: String): List<Vegetable> = (vegetableAdapter.fromJson(value) ?: emptyList()).also {
        println("toVegetables: $value -> ${it.joinToString()}}")
    }
}