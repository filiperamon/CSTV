package com.example.core.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor(
    private val publicKey: String
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
            .header("Authorization", "Bearer $publicKey")
            .build()

        return chain.proceed(newRequest)
    }
}