package com.ardev.proadts.modules.userlist.states

sealed class EventStateUserList {
    data class OnClickFollowers (val userId: String) : EventStateUserList()
    data class OnClickFollowing(val userId: String) : EventStateUserList()
    data class OnClickRepository(val userId: String) : EventStateUserList()
    data class OnClickBookmark(val userId: String) : EventStateUserList()
}