package com.ardev.proadts.modules.searchuser.states

sealed class PageStateSearchUser{
    object Loading : PageStateSearchUser()
    data class HasData(val data: String) : PageStateSearchUser()
    data class Failure(val message: String) : PageStateSearchUser()
    data class NoInternetConnection(val message: String) : PageStateSearchUser()
}
