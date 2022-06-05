package com.ardev.proadts.shared.services.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.ardev.proadts.middleware.Either
import retrofit2.Call
import java.net.SocketTimeoutException
import javax.inject.Singleton

@Singleton
class NetworkService constructor(private val context: Context) {

    fun isNetworkAvailable() : Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val nw = connectivityManager.activeNetwork ?: return false
            val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
            return when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                //for other device how are able to connect with Ethernet
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                //for check internet over Bluetooth
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
                else -> false
            }
        } else {
            return connectivityManager.activeNetworkInfo?.isConnected ?: false
        }
    }

    open fun <T, R> request(
        call: Call<T>,
        transform: (T) -> R,
        default: T
    ): Either<FailureStates, R> {
        return try {

            val response = call.execute()
            when (response.isSuccessful) {
                true -> Either.Right(transform(response.body() ?: default))
                false -> {
                    val failure: FailureStates = when (response.code()) {
                        400 -> FailureStates.ClientError
                        401 -> FailureStates.Unauthorized
                        403 -> FailureStates.ClientError
                        404 -> FailureStates.ServerError("404")
                        500, 501, 502 -> FailureStates.InternalError
                        503 -> FailureStates.ServerError("503")
                        else -> {
                            FailureStates.ServerError("Server Error")
                        }
                    }
                    Either.Left(failure)
                }
            }
        } catch (exception: Throwable) {
            when (exception) {
                is SocketTimeoutException -> {
                    Either.Left(FailureStates.Timeout)
                }
                else -> {
                    Either.Left(FailureStates.ServerError("Server Error"))
                }
            }
        }
    }
}