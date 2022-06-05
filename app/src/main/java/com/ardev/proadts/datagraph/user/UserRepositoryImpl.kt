package com.ardev.proadts.datagraph.user

import com.ardev.proadts.base.BaseClients
import com.ardev.proadts.models.response.BaseResponse
import com.ardev.proadts.models.response.user.RepositoryResponse
import com.ardev.proadts.models.response.user.SearchUserResponse
import com.ardev.proadts.models.response.user.UserResponse
import com.ardev.proadts.shared.services.network.FailureStates
import com.ardev.proadts.shared.services.network.NetworkHelper
import com.ardev.proadts.sourcedata.user.cloud.clients.ClientUsers
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val clientUsers: ClientUsers
) : BaseClients(),
    UserRepositoryInterface {
    override suspend fun getListUsers(): BaseResponse<List<UserResponse>> {
        return when (networkHelper.isConnected) {
            true -> safeApiCall { clientUsers.getListUsers() }
            false -> BaseResponse.failure(FailureStates.NetworkConnection)
        }
    }

    override suspend fun searchUser(keyword: String, page: Int): BaseResponse<SearchUserResponse> {
        return when (networkHelper.isConnected) {
            true -> safeApiCall { clientUsers.searchUser(keyword, page) }
            false -> BaseResponse.failure(FailureStates.NetworkConnection)
        }
    }

    override suspend fun getDetailUser(userId: String): BaseResponse<UserResponse> {
        return when (networkHelper.isConnected) {
            true -> safeApiCall { clientUsers.getDetailUser(userId) }
            false -> BaseResponse.failure(FailureStates.NetworkConnection)
        }
    }

    override suspend fun getListFollowers(userId: String): BaseResponse<List<UserResponse>> {
        return when (networkHelper.isConnected) {
            true -> safeApiCall { clientUsers.getListFollowers(userId) }
            false -> BaseResponse.failure(FailureStates.NetworkConnection)
        }
    }

    override suspend fun getListFollowing(userId: String): BaseResponse<List<UserResponse>> {
        return when (networkHelper.isConnected) {
            true -> safeApiCall { clientUsers.getListFollowing(userId) }
            false -> BaseResponse.failure(FailureStates.NetworkConnection)
        }
    }

    override suspend fun getListRepository(userId: String): BaseResponse<List<RepositoryResponse>> {
        return when (networkHelper.isConnected) {
            true -> safeApiCall { clientUsers.getListRepository(userId) }
            false -> BaseResponse.failure(FailureStates.NetworkConnection)
        }
    }

    override suspend fun likeUser() {
        TODO("Not yet implemented")
    }

//    override suspend fun getListRepository(userId: String): Either<FailureStates, List<RepositoryResponse>?> {
//        return when (networkHelper.isConnected) {
//            true -> {
//                safeApiCall { clientUsers.getListRepository(userId) }
////                networkHelper.request(clientUsers.getListRepository(userId), {
////                    it
////                }, ArrayList())
//            }
//            false, null -> Either.Left(FailureStates.NetworkConnection)
//        }
//    }

}