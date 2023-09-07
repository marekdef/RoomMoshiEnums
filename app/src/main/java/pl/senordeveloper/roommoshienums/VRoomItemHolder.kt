package pl.senordeveloper.roommoshienums

import androidx.recyclerview.widget.RecyclerView
import pl.senordeveloper.roommoshienums.databinding.RoomItemBinding
import pl.senordeveloper.roommoshienums.db.RoomItem

class VRoomItemHolder(
    private val roomItemBinding: RoomItemBinding
) : RecyclerView.ViewHolder(roomItemBinding.root) {
    fun bind(roomItem: RoomItem) {
        roomItemBinding.textViewHeader.text = roomItem.fruit.name
        roomItemBinding.textViewContent.text = roomItem.fruits.joinToString(",")
        roomItemBinding.textViewHeader2.text = roomItem.vegetable.name
        roomItemBinding.textViewContent2.text = roomItem.vegetables.joinToString()
    }
}
