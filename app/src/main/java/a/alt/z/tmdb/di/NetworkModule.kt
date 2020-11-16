package a.alt.z.tmdb.di

import a.alt.z.tmdb.data.remote.AuthInterceptor
import a.alt.z.tmdb.data.remote.BASE_URL
import a.alt.z.tmdb.data.remote.TmdbService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides @Singleton
    fun providesAuthInterceptor(): Interceptor = AuthInterceptor()

    @Provides @Singleton
    fun providesOkHttpClient(interceptor: Interceptor): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Provides @Singleton
    fun providesRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides @Singleton
    fun providesTmdbService(retrofit: Retrofit): TmdbService = retrofit.create(TmdbService::class.java)
}