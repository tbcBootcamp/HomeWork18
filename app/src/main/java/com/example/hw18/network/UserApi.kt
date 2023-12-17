package com.example.hw18.network

import com.example.hw18.models.PageModel
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersApi {
    @GET("users")
    suspend fun getUsers(@Query("page") pageNumber: Int): PageModel
}