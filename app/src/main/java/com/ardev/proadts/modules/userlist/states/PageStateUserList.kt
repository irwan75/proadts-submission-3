package com.ardev.proadts.modules.userlist.states

import com.ardev.proadts.models.response.user.UserResponse

sealed class PageStateUserList{
    object Loading : PageStateUserList()
    data class HasData(val listUsers: List<UserResponse>?) : PageStateUserList()
    data class Failure(val message: String) : PageStateUserList()
    data class NoInternetConnection(val message: String) : PageStateUserList()
}
