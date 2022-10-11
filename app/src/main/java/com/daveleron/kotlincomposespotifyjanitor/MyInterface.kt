package com.daveleron.kotlincomposespotifyjanitor

import retrofit2.http.GET
import java.util.ArrayList

interface MyApiService {
    @GET("users")
    suspend fun getEmployees(): ArrayList<Employee>
}