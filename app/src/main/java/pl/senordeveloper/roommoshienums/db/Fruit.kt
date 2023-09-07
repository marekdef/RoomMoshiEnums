package pl.senordeveloper.roommoshienums.db

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
enum class Fruit {
    APPLE,
    ORANGE,
    PEACH,
    PEAR,
    BANANA,
    MANGO,
    PINEAPPLE,
    KIWI,
    STRAWBERRY,
    RASPBERRY,
    BLUEBERRY,
    BLACKBERRY,
    CHERRY,
}