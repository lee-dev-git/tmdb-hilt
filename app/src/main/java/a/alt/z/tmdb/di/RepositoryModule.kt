package a.alt.z.tmdb.di

import a.alt.z.tmdb.data.repository.MovieRepositoryImpl
import a.alt.z.tmdb.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsMovieRepository(repository: MovieRepositoryImpl): MovieRepository
}