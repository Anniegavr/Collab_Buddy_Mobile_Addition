package com.example.jetnews.utils

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val token: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val authenticatedRequest = request.newBuilder()
            .header("Authorization", "Bearer $token")
            .build()
        return chain.proceed(authenticatedRequest)
    }
}
