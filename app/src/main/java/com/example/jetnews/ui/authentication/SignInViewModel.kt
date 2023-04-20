package com.example.jetnews.ui.authentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetnews.data.users.SignInRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

data class SignInUiState(
    val email: String = "",
    val password: String = "",
    val loading: Boolean = false,
    val error: String = ""
)

class SignInViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(SignInUiState())
    val uiState: StateFlow<SignInUiState> = _uiState

    fun signIn(email: String, password: String) {
        _uiState.value = _uiState.value.copy(loading = true)
        val client = OkHttpClient()

        val mediaType = "application/json; charset=utf-8".toMediaType()
        val requestBody = """
            {
                "email": "$email",
                "password": "$password"
            }
        """.trimIndent().toRequestBody(mediaType)

        val request = Request.Builder()
            .url("http://10.0.2.2:8080/api/auth/signin")
            .post(requestBody)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                _uiState.value = _uiState.value.copy(loading = false, error = e.message ?: "Unknown error")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                if (response.isSuccessful && body != null) {
                    // Handle successful sign in
                } else {
                    _uiState.value = _uiState.value.copy(loading = false, error = "Invalid email or password")
                }
            }
        })
    }

    companion object {
        fun provideFactory(signInRepository: SignInRepository): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return SignInViewModel() as T
            }
        }
    }
}
