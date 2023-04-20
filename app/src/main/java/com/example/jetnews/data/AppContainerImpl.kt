

package com.example.jetnews.data

import android.content.Context
import com.example.jetnews.data.interests.InterestsRepository
import com.example.jetnews.data.interests.impl.FakeInterestsRepository
import com.example.jetnews.data.posts.PostsRepository
import com.example.jetnews.data.posts.impl.FakePostsRepository
import com.example.jetnews.data.users.SignInRepository
import com.example.jetnews.data.users.impl.SignInRepositoryImpl

/**
 * Dependency Injection container at the application level.
 */
interface AppContainer {
    val postsRepository: PostsRepository
    val interestsRepository: InterestsRepository
    val signInRepository: SignInRepository
}

/**
 * Implementation for the Dependency Injection container at the application level.
 *
 * Variables are initialized lazily and the same instance is shared across the whole app.
 */
class AppContainerImpl(private val applicationContext: Context) : AppContainer {

    override val postsRepository: PostsRepository by lazy {
        FakePostsRepository()
    }

    override val interestsRepository: InterestsRepository by lazy {
        FakeInterestsRepository()
    }

    override val signInRepository: SignInRepository by lazy {
        SignInRepositoryImpl()
    }
}
