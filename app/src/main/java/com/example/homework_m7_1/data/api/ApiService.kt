package com.example.homework_m7_1.data.api

import com.example.homework_m7_1.data.Camera
import com.example.homework_m7_1.data.Door
import retrofit2.http.GET

interface ApiService {
    @GET("cameras/")
    suspend fun getCamera(): List<Camera>

    @GET("doors/")
    suspend fun getDoor(): List<Door>
}