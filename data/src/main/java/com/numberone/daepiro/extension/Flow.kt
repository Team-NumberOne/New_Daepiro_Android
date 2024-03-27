package com.numberone.daepiro.extension

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow

//fun <T, R> Flow<Outcome<T>>.flatMapOutcomeSuccess(domainMapper: suspend (T) -> R): Flow<Outcome<R>> {
//    return this.flatMapConcat { outcome ->
//        flow {
//            when (outcome) {
//                is Outcome.Success -> emit(Outcome.Success(domainMapper(outcome.data)))
//                is Outcome.Failure -> emit(Outcome.Failure(outcome.error))
//            }
//        }
//    }
//}

fun <T, R> Flow<T>.flatMapDomain(domainMapper: suspend (T) -> R): Flow<R> {
    return this.flatMapConcat { data ->
        flow {
            emit(domainMapper(data))
        }
    }
}