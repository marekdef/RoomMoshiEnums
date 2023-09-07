package pl.senordeveloper.roommoshienums

import android.app.Application
import androidx.room.Room
import com.facebook.flipper.android.AndroidFlipperClient
// import com.facebook.flipper.android.utils.FlipperUtils
// import com.facebook.flipper.plugins.databases.DatabasesFlipperPlugin
// import com.facebook.flipper.plugins.inspector.DescriptorMapping
// import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
// import com.facebook.soloader.SoLoader
import pl.senordeveloper.roommoshienums.db.RoomDatabase

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        // SoLoader.init(this, false)
        //
        // if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
        //
        //     val descriptorMapping = DescriptorMapping.withDefaults();
        //
        //     val client = AndroidFlipperClient.getInstance(this)
        //     client.addPlugin( DatabasesFlipperPlugin(this));
        //     client.addPlugin(InspectorFlipperPlugin(this, descriptorMapping))
        //     client.start()
        // }
    }

    companion object {
        lateinit var instance: MainApplication
            private set

        private val database by lazy {
            try {
                Room.databaseBuilder(
                    instance,
                    RoomDatabase::class.java, "database-name"
                ).fallbackToDestructiveMigration().build()
            } catch (e: Exception) {
                e.printStackTrace()
                e.cause?.printStackTrace()
                throw e
            }

        }

        val roomItems by lazy {
            database.roomItems()
        }
    }
}