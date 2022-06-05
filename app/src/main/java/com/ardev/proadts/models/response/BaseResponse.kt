package com.ardev.proadts.models.response

import com.ardev.proadts.shared.services.network.FailureStates
import retrofit2.Response

data class BaseResponse<T>(
    val status: Status,
    val data: Response<T>?,
    val exception: FailureStates?
) {

    companion object {
        fun <T> success(data: Response<T>): BaseResponse<T> {
            return BaseResponse(
                status = Status.Success,
                data = data,
                exception = null
            )
        }

        fun <T> failure(exception: FailureStates): BaseResponse<T> {
            return BaseResponse(
                status = Status.Failure,
                data = null,
                exception = exception
            )
        }
    }

    sealed class Status {
        object Success : Status()
        object Failure : Status()
    }

    val failed: Boolean
        get() = this.status == Status.Failure

    val isSuccessful: Boolean
        get() = !failed && this.data?.isSuccessful == true

    val body: T
        get() = this.data!!.body()!!

    val bodyNullable: T?
        get() = this.data?.body()
}