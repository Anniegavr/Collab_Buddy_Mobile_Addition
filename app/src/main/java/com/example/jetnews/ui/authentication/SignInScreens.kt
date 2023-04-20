package com.example.jetnews.ui.authentication
import android.graphics.drawable.Icon
import android.media.Image
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.*
import okhttp3.*
import androidx.compose.runtime.Composable


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetnews.R
import com.example.jetnews.data.posts.impl.post1
import com.example.jetnews.ui.theme.JetnewsTheme
import kotlin.text.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(

) {
    val viewModel: SignInViewModel = viewModel()

    val uiState by viewModel.uiState.collectAsState()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(26.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.ic_welcome_foreground),
            contentDescription = "welcome image",
            modifier = Modifier.size(100.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { viewModel.signIn(email, password) },
            modifier = Modifier.fillMaxWidth(),
            enabled = !uiState.loading
        ) {
            Text(if (uiState.loading) "Signing in..." else "Sign in")

        }
        Text(if (uiState.loading) "You will be signed in in a second" else "")



        if (uiState.error.isNotBlank()) {
            Text(
                uiState.error,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }

    LaunchedEffect(uiState) {
        if (uiState.loading) {
            // show loading indicator, e.g. using a progress dialog
        } else if (uiState.error.isNotBlank()) {
            // show error message, e.g. using a snackbar
        } else {
            // successful sign in, navigate to next screen
        }
    }
}