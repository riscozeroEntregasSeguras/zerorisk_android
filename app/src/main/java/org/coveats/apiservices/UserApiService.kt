package org.coveats.apiservices

import org.coveats.models.User

class UserApiService {
    //val client =  OkHttpClient()

    fun getUser(email: String): User? {
        //return User("email@gmail.com")
        return null
        //todo replace with API call
        /*val request = Request.Builder()
            .url(USER_URL)
            .build()

        try {
            val response = client.newCall(request).execute()
            response.body?.string()
        }*/
    }
}