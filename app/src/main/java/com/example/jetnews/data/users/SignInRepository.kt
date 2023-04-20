package com.example.jetnews.data.users

import com.example.jetnews.data.Result

interface SignInRepository {
    /**
     * Get list of people.
     */
    suspend fun getPeople(): Result<List<String>>
    suspend fun signIn(user: String): Result<String>
}