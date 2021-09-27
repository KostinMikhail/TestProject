package com.example.newproject.repository

import com.example.newproject.api.RetrofitInstance
import com.example.newproject.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

}