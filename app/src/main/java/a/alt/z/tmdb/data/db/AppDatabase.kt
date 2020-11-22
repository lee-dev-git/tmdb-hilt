package a.alt.z.tmdb.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [MovieEntity::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        private const val databaseName = "aaltz"

        fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, databaseName)
                    .build()
        }
    }
}