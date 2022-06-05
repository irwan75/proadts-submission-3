package com.ardev.proadts.shared.services.retrofit

import com.ardev.proadts.shared.services.network.NetworkService
import okhttp3.OkHttpClient
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitHelper @Inject constructor(private val retrofitService: RetrofitService) {

    fun getLoggingHttpClient(): OkHttpClient = retrofitService.getLoggingHttpClient()

}