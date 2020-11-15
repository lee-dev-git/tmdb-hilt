package a.alt.z.tmdb.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class UseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(parameters: P): Result<R> {
        return try { withContext(coroutineDispatcher) { Result.Success(execute(parameters)) } }
        catch (exception: Exception) { Result.Error(exception) }
    }

    protected abstract fun execute(parameters: P): R
}