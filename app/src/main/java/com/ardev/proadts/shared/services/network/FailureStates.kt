package com.ardev.proadts.shared.services.network

import com.ardev.proadts.shared.extension.empty
import com.ardev.proadts.shared.extension.initial

sealed class FailureStates  {

    var message: String = String.empty()

    object NetworkConnection : FailureStates(){
        operator fun invoke(message: String = ""): FailureStates {
            this.message = "NetworkConnection: $message"
            return this
        }
    }

    object Timeout : FailureStates(){
        operator fun invoke(message: String = ""): FailureStates {
            this.message = "RequestTimeOut: $message"
            return this
        }
    }

    object ServerError : FailureStates() {
        operator fun invoke(message: String = ""): FailureStates {
            this.message = "ServerError: $message"
            return this
        }
    }

    object ClientError : FailureStates(){
        operator fun invoke(message: String = ""): FailureStates {
            this.message = "ClientError: $message"
            return this
        }
    }

    object InternalError : FailureStates(){
        operator fun invoke(message: String=""): FailureStates {
            this.message = "InternalError: $message"
            return this
        }
    }

    object Unauthorized : FailureStates(){
        operator fun invoke(message: String = ""): FailureStates {
            this.message = "Unauthorized: $message"
            return this
        }
    }


}
