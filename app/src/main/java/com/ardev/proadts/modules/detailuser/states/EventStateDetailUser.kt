package com.ardev.proadts.modules.detailuser.states

sealed class EventStateDetailUser {
    data class OnClickFollowers (val userId: String) : EventStateDetailUser()
    data class OnClickFollowing(val userId: String) : EventStateDetailUser()
    data class OnClickRepository(val userId: String) : EventStateDetailUser()
    data class OnClickBookmark(val userId: String) : EventStateDetailUser()
}