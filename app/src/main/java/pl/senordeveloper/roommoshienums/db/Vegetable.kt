package pl.senordeveloper.roommoshienums.db

enum class Vegetable {
    CARROT,
    POTATO,
    ONION,
}

data class VegetableWrap(
    val vegetable: Vegetable
) {
    val name: CharSequence = vegetable.name
}