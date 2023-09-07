package pl.senordeveloper.roommoshienums

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.senordeveloper.roommoshienums.databinding.RoomItemBinding
import pl.senordeveloper.roommoshienums.db.RoomItem

class VRoomAdapter : RecyclerView.Adapter<VRoomItemHolder>() {
    private var items = emptyList<RoomItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VRoomItemHolder =
        VRoomItemHolder(RoomItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: VRoomItemHolder, position: Int) = holder.bind(
        items[position]
    )

    fun replaceItems(items: List<RoomItem>) {
        this.items = items
        notifyDataSetChanged()
    }
}
