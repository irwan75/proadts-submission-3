package com.ardev.proadts.datagraph.user

import com.ardev.proadts.models.response.BaseResponse
import com.ardev.proadts.models.response.user.RepositoryResponse
import com.ardev.proadts.models.response.user.SearchUserResponse
import com.ardev.proadts.models.response.user.UserResponse

interface UserRepositoryInterface {

    suspend fun getListUsers(): BaseResponse<List<UserResponse>>

    suspend fun searchUser(keyword: String, page: Int): BaseResponse<SearchUserResponse>

    suspend fun getDetailUser(userId: String): BaseResponse<UserResponse>

    suspend fun getListFollowers(userId: String): BaseResponse<List<UserResponse>>

    suspend fun getListFollowing(userId: String): BaseResponse<List<UserResponse>>

    suspend fun getListRepository(userId: String): BaseResponse<List<RepositoryResponse>>

    suspend fun likeUser()
}