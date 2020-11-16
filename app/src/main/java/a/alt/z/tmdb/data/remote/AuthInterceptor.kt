package a.alt.z.tmdb.data.remote

import a.alt.z.tmdb.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

class AuthInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val httpUrl = chain.request()
            .url
            .newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY)
            .build()

        val request = chain.request()
            .newBuilder()
            .url(url = httpUrl)
            .build()

        return chain.proceed(request)
    }
}