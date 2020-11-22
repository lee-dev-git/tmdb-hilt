package a.alt.z.tmdb.di

import a.alt.z.tmdb.data.db.AppDatabase
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Provides @Singleton
    fun providesAppDatabase(@ApplicationContext context: Context) = AppDatabase.buildDatabase(context)

    @Provides @Singleton
    fun providesMovieDao(database: AppDatabase) = database.movieDao()
}