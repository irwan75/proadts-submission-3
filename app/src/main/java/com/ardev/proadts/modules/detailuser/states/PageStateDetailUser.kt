package com.ardev.proadts.modules.detailuser.states

sealed class PageStateDetailUser{
    object Loading : PageStateDetailUser()
    data class HasData(val data: String) : PageStateDetailUser()
    data class Failure(val message: String) : PageStateDetailUser()
    data class NoInternetConnection(val message: String) : PageStateDetailUser()
}
