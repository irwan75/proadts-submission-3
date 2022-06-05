package com.ardev.proadts.modules.searchuser.states

sealed class EventStateSearchUser {
    data class OnClickFollowers (val userId: String) : EventStateSearchUser()
    data class OnClickFollowing(val userId: String) : EventStateSearchUser()
    data class OnClickRepository(val userId: String) : EventStateSearchUser()
    data class OnClickBookmark(val userId: String) : EventStateSearchUser()
}