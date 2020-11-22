package a.alt.z.tmdb.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

sealed class LoadState<out T> {
    object Loading : LoadState<Nothing>()
    class Loaded<T>(val value: T) : LoadState<T>()
    class Error<T>(val e: Throwable) : LoadState<T>()

    val isLoading get() = this is Loading
    fun getErrorIfExists() = if (this is Error) e else null
    fun getValueOrNull(): T? = if (this is Loaded<T>) value else null
}

fun <T> Flow<T>.toLoadState(): Flow<LoadState<T>> {
    return map<T, LoadState<T>> { LoadState.Loaded(it) }
        .onStart { emit(LoadState.Loading) }
        .catch { e -> emit(LoadState.Error(e)) }
}