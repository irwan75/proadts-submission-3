package com.ardev.proadts.modules.detailuser.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ardev.proadts.base.BaseViewModel
import com.ardev.proadts.datagraph.user.UserRepositoryImpl
import com.ardev.proadts.modules.detailuser.states.EventStateDetailUser
import com.ardev.proadts.modules.detailuser.states.PageStateDetailUser
import com.ardev.proadts.shared.services.network.FailureStates
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailUserViewModel @Inject constructor (private val userRepositoryImpl: UserRepositoryImpl) : BaseViewModel() {

    private val _pageState = MutableLiveData<PageStateDetailUser>(PageStateDetailUser.Loading)
    val getPageState: LiveData<PageStateDetailUser> = _pageState

    fun onClickEvent(eventState: EventStateDetailUser){
        when (eventState) {
            is EventStateDetailUser.OnClickFollowers -> {
                printInfo("On Click Followers ${eventState.userId}")
            }
            is EventStateDetailUser.OnClickFollowing -> {
                printInfo("On Click Following ${eventState.userId}")
            }
            is EventStateDetailUser.OnClickRepository -> {
                printInfo("On Click Repository ${eventState.userId}")
            }
            is EventStateDetailUser.OnClickBookmark -> {
                printInfo("On Click Bookmark ${eventState.userId}")
            }
        }
    }

    override fun handleFailure(failure: FailureStates?) {
        TODO("Not yet implemented")
    }

}