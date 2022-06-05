package com.ardev.proadts.shared.services.network

import com.ardev.proadts.middleware.Either
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkHelper @Inject constructor(private val networkService: NetworkService) {

    val isConnected get() = networkService.isNetworkAvailable()

    fun <T, R> request(
        call: Call<T>,
        transform: (T) -> R,
        default: T
    ): Either<FailureStates, R> {
        return networkService.request(call, transform, default)
    }

}