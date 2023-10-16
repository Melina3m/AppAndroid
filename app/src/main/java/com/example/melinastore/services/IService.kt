package com.example.melinastore.services

import com.example.melinastore.models.DogResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface IService {
    @GET
    suspend fun getDogs(@Url url: String): Response<DogResponse>
}