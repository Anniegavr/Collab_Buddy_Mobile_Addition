/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jetnews.ui.authentication

import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.jetnews.ui.home.HomeUiState
import com.example.jetnews.ui.home.HomeViewModel
import com.example.jetnews.ui.interests.InterestsScreen
import com.example.jetnews.ui.interests.rememberTabContent

/**
 * Displays the SignIn route.
 *
 * Note: AAC ViewModels don't work with Compose Previews currently.
 *
 * @param SignInViewModel ViewModel that handles the business logic of this screen
 * @param isExpandedScreen (state) whether the screen is expanded
 * @param openDrawer (event) request opening the app drawer
 * @param snackbarHostState (state) state for the [Scaffold] component on this screen
 */
@Composable
fun SignInRoute(
    signInViewModel: SignInViewModel,
    isExpandedScreen: Boolean,
    openDrawer: () -> Unit,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
) {
    val uiState by signInViewModel.uiState.collectAsStateWithLifecycle()
    SignInRoute(
    )
}

/**
 * Displays the SignIn route.
 *
 * This composable is not coupled to any specific state management.

 */
@Composable
fun SignInRoute(
) {

    SignInScreen()
}