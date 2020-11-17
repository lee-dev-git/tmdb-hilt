package a.alt.z.tmdb.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

abstract class FlowUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    operator fun invoke(parameters: P): Flow<R> = execute(parameters)
        .flowOn(coroutineDispatcher)

    protected abstract fun execute(parameters: P): Flow<R>
}