package pl.senordeveloper.roommoshienums.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomItem(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val fruit: Fruit,
    val fruits: List<Fruit>,
    val vegetable: VegetableWrap,
    val vegetables: List<VegetableWrap>
)
