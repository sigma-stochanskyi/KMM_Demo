package com.nanit.kmmdemo.utils

inline fun <T> Result<T>.successOnFailure(action: (it: Throwable) -> T): Result<T> {
    exceptionOrNull()?.let {
        return Result.success(action(it))
    }

    return this
}