package a.alt.z.tmdb.api

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val httpUrl = chain.request()
            .url
            .newBuilder()
            .addQueryParameter("api_key", "")
            .build()

        val request = chain.request()
            .newBuilder()
            .url(url = httpUrl)
            .build()

        return chain.proceed(request)
    }
}