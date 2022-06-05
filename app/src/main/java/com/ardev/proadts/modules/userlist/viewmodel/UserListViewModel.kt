package com.ardev.proadts.modules.userlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ardev.proadts.base.BaseViewModel
import com.ardev.proadts.datagraph.user.UserRepositoryImpl
import com.ardev.proadts.modules.userlist.states.PageStateUserList
import com.ardev.proadts.shared.services.network.FailureStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(private val userRepositoryImpl: UserRepositoryImpl) :
    BaseViewModel() {

    private val _pageState = MutableLiveData<PageStateUserList>(PageStateUserList.Loading)
    val getPageState: LiveData<PageStateUserList> = _pageState

    private var mFetchUserListJob: Job? = null

    override fun onCleared() {
        super.onCleared()
        mFetchUserListJob.let {
            it!!.cancel()
        }
    }

    fun fetchListUsers() {
        mFetchUserListJob = viewModelScope.launch {
            val responseListUsers = userRepositoryImpl.getListUsers()
            if (responseListUsers.isSuccessful) {
                _pageState.postValue(PageStateUserList.HasData(responseListUsers.body))
                mFetchUserListJob!!.cancel()
            } else {
                handleFailure(responseListUsers.exception)
                mFetchUserListJob!!.cancel()
            }
        }
    }

    override fun handleFailure(failure: FailureStates?) {
        when (failure) {
            is FailureStates.NetworkConnection -> _pageState.postValue(
                PageStateUserList.NoInternetConnection(
                    "No Internet Connection"
                )
            )
            else ->
                _pageState.postValue(
                    PageStateUserList.Failure(
                        message = failure?.message ?: "Failure"
                    )
                )
        }
    }

    //        viewModelScope.launch {
//            when (val responseListUsers = userRepositoryImpl.getListUsers()) {
//                is Either.Left ->
//                    _pageState.postValue(
//                        PageStateUserList.Failure(
//                            message = "Error",
//                            statusCode = 400
//                        )
//                    )
//                is Either.Right -> responseListUsers.map {
//                    _pageState.postValue(PageStateUserList.HasData(it))
//                }
//            }
//        }


}