package com.ardev.proadts.di

import android.app.Application
import com.ardev.proadts.datagraph.user.UserRepositoryImpl
import com.ardev.proadts.shared.services.network.NetworkHelper
import com.ardev.proadts.shared.services.network.NetworkService
import com.ardev.proadts.shared.constants.AppConstants
import com.ardev.proadts.shared.services.retrofit.RetrofitHelper
import com.ardev.proadts.shared.services.retrofit.RetrofitService
import com.ardev.proadts.sourcedata.user.cloud.api.ApiUsers
import com.ardev.proadts.sourcedata.user.cloud.clients.ClientUsers
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Services
    @Provides
    @Singleton
    fun networkHelper(context: Application): NetworkHelper {
        return NetworkHelper(NetworkService(context))
    }

    @Provides
    @Singleton
    fun retrofitHelper(): RetrofitHelper{
        return RetrofitHelper(RetrofitService())
    }

    @Singleton
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun retrofit(retrofitHelper: RetrofitHelper): Retrofit {
        return Retrofit.Builder().client( retrofitHelper.getLoggingHttpClient())
            .baseUrl(AppConstants.Network.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
    }

    // Api
    @Provides
    @Singleton
    fun apiUsers(retrofit: Retrofit): ApiUsers {
        return retrofit.create(ApiUsers::class.java)
    }

    // Cloud Client
    @Provides
    @Singleton
    fun clientUsers(apiUsers: ApiUsers): ClientUsers{
        return ClientUsers(apiUsers)
    }

    // Data Graph
    @Provides
    @Singleton
    fun userRepository(networkHelper: NetworkHelper, clientUsers: ClientUsers): UserRepositoryImpl {
        return UserRepositoryImpl(networkHelper, clientUsers)
    }


}