package com.ardev.proadts.base

import com.ardev.proadts.models.response.BaseResponse
import com.ardev.proadts.shared.services.network.FailureStates
import retrofit2.Response
import java.net.SocketTimeoutException

open class BaseClients {

    inline fun <T> safeApiCall(apiCall: () -> Response<T>): BaseResponse<T> {
        return try {
            val response = apiCall.invoke()

            if (response.isSuccessful){
                BaseResponse.success(response)
            }else{
                //            var errorMessage = response.message()
//            errorMessage = getErrorMessageFromBody(response.errorBody(), errorMessage)
                val failure: FailureStates = when (response.code()) {
                    400 -> FailureStates.ClientError
                    401 -> FailureStates.Unauthorized
                    403 -> FailureStates.ClientError
                    404 -> FailureStates.ServerError
                    500, 501, 502 -> FailureStates.InternalError
                    503 -> FailureStates.ServerError
                    else -> {
                        FailureStates.ServerError
                    }
                }
                BaseResponse.failure(failure)
            }
        } catch (exception: Exception) {
            when (exception) {
                is SocketTimeoutException ->
                    BaseResponse.failure(FailureStates.Timeout)
                else -> BaseResponse.failure(FailureStates.ServerError)
            }

        }
    }

}