package com.example.jetnews.data.users.impl

import com.example.jetnews.data.Result
import com.example.jetnews.data.users.SignInRepository

class SignInRepositoryImpl : SignInRepository {
    private val people by lazy {
        listOf(
            "Kobalt Toral",
            "K'Kola Uvarek",
            "Kris Vriloc",
            "Grala Valdyr",
            "Kruel Valaxar",
            "L'Elij Venonn",
            "Kraag Solazarn",
            "Tava Targesh",
            "Kemarrin Muuda",
            "Annie Gavr"
        )
    }
    override suspend fun getPeople(): Result<List<String>> {
//        TODO("Return real data")
        return Result.Success(people)
    }

    override suspend fun signIn(user: String): Result<String> {
//        TODO("Not yet implemented")
        people.listIterator().forEach { list_user: String -> if (user == list_user){
        return Result.Success(user)}
        }
        return Result.Success("Sorry, user not found")
    }

}