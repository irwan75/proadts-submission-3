package com.ardev.proadts.sourcedata.user.cloud.api

import com.ardev.proadts.models.response.user.RepositoryResponse
import com.ardev.proadts.models.response.user.SearchUserResponse
import com.ardev.proadts.models.response.user.UserResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiUsers {

    companion object {
        private const val LIST_USERS = "/users?per_page=50"
        private const val SEARCH_USER = "/search/users?q={keyword}&page={page}&per_page=50"
        private const val DETAIL_USER = "/users/{userId}"
        private const val FOLLOWERS_LIST = "/users/{userId}/followers"
        private const val FOLLOWING_LIST = "/users/{userId}/following"
        private const val REPOSITORIES_LIST = "/users/{userId}/repos"
    }

    @GET(LIST_USERS)
    suspend fun getListUsers(): Response<List<UserResponse>>

    @GET(SEARCH_USER)
    suspend fun searchUser(
        @Path("keyword") keyword: String,
        @Path("page") page: Int
    ): Response<SearchUserResponse>

    @GET(DETAIL_USER)
    suspend fun getDetailUser(
        @Path("userId") userId: String,
    ): Response<UserResponse>

    @GET(FOLLOWERS_LIST)
    suspend fun getListFollowers(
        @Path("userId") userId: String,
    ): Response<List<UserResponse>>

    @GET(FOLLOWING_LIST)
    suspend fun getListFollowing(
        @Path("userId") userId: String,
    ): Response<List<UserResponse>>

    @GET(REPOSITORIES_LIST)
    suspend fun getListRepository(
        @Path("userId") userId: String,
    ): Response<List<RepositoryResponse>>

}