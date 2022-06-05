package com.ardev.proadts.sourcedata.user.cloud.clients

import android.util.Log
import com.ardev.proadts.models.response.user.RepositoryResponse
import com.ardev.proadts.models.response.user.SearchUserResponse
import com.ardev.proadts.models.response.user.UserResponse
import com.ardev.proadts.sourcedata.user.cloud.api.ApiUsers
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class ClientUsers @Inject constructor(private val apiUsers: ApiUsers) : ApiUsers  {

    override suspend fun getListUsers(): Response<List<UserResponse>> {
        return apiUsers.getListUsers()
    }

    override suspend fun searchUser(keyword: String, page: Int): Response<SearchUserResponse> {
        return apiUsers.searchUser(keyword, page)
    }

    override suspend fun getDetailUser(userId: String): Response<UserResponse> {
        return apiUsers.getDetailUser(userId)
    }

    override suspend fun getListFollowers(userId: String): Response<List<UserResponse>> {
        return apiUsers.getListFollowers(userId)
    }

    override suspend fun getListFollowing(userId: String): Response<List<UserResponse>> {
        return apiUsers.getListFollowing(userId)
    }

    override suspend fun getListRepository(userId: String): Response<List<RepositoryResponse>> {
        return apiUsers.getListRepository(userId)
    }


}