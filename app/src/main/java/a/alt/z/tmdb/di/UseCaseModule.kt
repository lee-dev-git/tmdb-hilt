package a.alt.z.tmdb.di

import a.alt.z.tmdb.domain.repository.MovieRepository
import a.alt.z.tmdb.domain.usecase.popular.GetPopularMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object UseCaseModule {

    @Singleton @Provides
    fun providesGetPopularMoviesUseCase(
            movieRepository: MovieRepository,
            @IODispatcher coroutineDispatcher: CoroutineDispatcher
    ): GetPopularMoviesUseCase = GetPopularMoviesUseCase(movieRepository, coroutineDispatcher)
}