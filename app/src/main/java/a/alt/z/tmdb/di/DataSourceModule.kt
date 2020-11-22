package a.alt.z.tmdb.di

import a.alt.z.tmdb.data.source.DBMovieDataSource
import a.alt.z.tmdb.data.source.MovieLocalDataSource
import a.alt.z.tmdb.data.source.MovieRemoteDataSource
import a.alt.z.tmdb.data.source.TmdbMovieDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindMovieLocalDataSource(dbMovieDataSource: DBMovieDataSource): MovieLocalDataSource

    @Binds
    abstract fun bindMovieRemoteDataSource(tmdbMovieDataSource: TmdbMovieDataSource): MovieRemoteDataSource
}