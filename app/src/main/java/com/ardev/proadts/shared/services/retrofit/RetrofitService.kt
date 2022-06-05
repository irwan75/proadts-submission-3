package com.ardev.proadts.shared.services.retrofit

import com.ardev.proadts.base.AndroidApplication
import com.ardev.proadts.shared.constants.AppConstants
import com.ardev.proadts.middleware.CustomInterceptor
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.logging.HttpLoggingInterceptor

@Singleton
class RetrofitService  {

    private val customInterceptor: CustomInterceptor = CustomInterceptor()

    fun getLoggingHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder().connectTimeout(AppConstants.Network.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(AppConstants.Network.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(AppConstants.Network.CONNECTION_TIMEOUT, TimeUnit.SECONDS)

        builder.addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })

        builder.addInterceptor(interceptor = customInterceptor)

        builder.addInterceptor(
            ChuckerInterceptor.Builder(AndroidApplication.context)
                .collector(ChuckerCollector(AndroidApplication.context))
                .maxContentLength(250000L)
                .redactHeaders(emptySet())
                .alwaysReadResponseBody(false)
                .build()
        )


        return builder.build()
    }

}