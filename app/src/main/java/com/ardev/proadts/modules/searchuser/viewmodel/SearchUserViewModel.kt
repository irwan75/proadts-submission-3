package com.ardev.proadts.modules.searchuser.viewmodel

import com.ardev.proadts.base.BaseViewModel
import com.ardev.proadts.datagraph.user.UserRepositoryImpl
import com.ardev.proadts.shared.services.network.FailureStates
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchUserViewModel @Inject constructor (private val userRepositoryImpl: UserRepositoryImpl) : BaseViewModel() {
    override fun handleFailure(failure: FailureStates?) {
        TODO("Not yet implemented")
    }
}