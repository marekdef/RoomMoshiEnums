package pl.senordeveloper.roommoshienums

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import pl.senordeveloper.roommoshienums.databinding.ActivityMainBinding
import pl.senordeveloper.roommoshienums.db.Fruit
import pl.senordeveloper.roommoshienums.db.RoomItem
import pl.senordeveloper.roommoshienums.db.Vegetable
import pl.senordeveloper.roommoshienums.db.VegetableWrap

class MainActivity : AppCompatActivity() {
    private val activityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val vRoomAdapter = VRoomAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)
        activityMainBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        activityMainBinding.recyclerView.itemAnimator = DefaultItemAnimator()
        activityMainBinding.recyclerView.adapter = vRoomAdapter

        activityMainBinding.button.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                MainApplication.roomItems.insertAll(
                    RoomItem(
                        id = 0,
                        fruit = randomEnum(),
                        fruits = listOf<Fruit>(
                            randomEnum(),
                            randomEnum(),
                            randomEnum(),
                            randomEnum()
                        ).toSet().toList(),
                        vegetable = VegetableWrap(randomEnum<Vegetable>()),
                        vegetables = listOf<Vegetable>(
                            randomEnum(),
                            randomEnum()
                        ).toSet().toList().map { VegetableWrap(it) }

                    )
                )
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                MainApplication.roomItems.getAll().collectLatest {
                    vRoomAdapter.replaceItems(it)
                }
            }
        }
    }
}

private inline fun <reified E : Enum<E>> randomEnum() = enumValues<E>().random()

