package pl.senordeveloper.roommoshienums.db

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

object VegetableWrapConverter {
    @TypeConverter
    fun fromVegetableWrap(value: VegetableWrap): String = value.vegetable.name.also {
        println("fromVegetableWrap: ${value.vegetable} -> $it")
    }

    @TypeConverter
    fun toVegetableWrap(value: String): VegetableWrap = VegetableWrap(Vegetable.valueOf(value)).also {
        println("toVegetableWrap: $value -> ${it.vegetable}}")
    }

    @TypeConverter
    fun fromVegetableWraps(value: List<VegetableWrap>): String = VegetableConverter.fromVegetables(value.map {
        it.vegetable
    }).also {
        println("fromVegetableWraps: ${value.joinToString()} -> $it")
    }

    @TypeConverter
    fun toVegetableWraps(value: String): List<VegetableWrap> = VegetableConverter.toVegetables(value).map {
        VegetableWrap(it)
    }.also {
        println("toVegetableWraps: $value -> ${it.joinToString()}}")
    }
}