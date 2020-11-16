package a.alt.z.tmdb.domain

import kotlinx.coroutines.*

abstract class UseCase<in P, R> {

    suspend operator fun invoke(parameters: P): Result<R> {
        return try { Result.Success(withContext(Dispatchers.IO) { execute(parameters) }) }
        catch (exception: Exception) { Result.Error(exception) }
    }

    protected abstract fun execute(parameters: P): R
}