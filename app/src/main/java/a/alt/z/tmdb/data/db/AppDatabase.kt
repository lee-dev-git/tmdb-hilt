package a.alt.z.tmdb.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun personDao(): PersonDao
}