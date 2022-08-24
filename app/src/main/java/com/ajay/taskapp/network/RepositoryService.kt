package com.ajay.taskapp.network

import com.ajay.taskapp.domain.Repository
import retrofit2.http.GET

interface RepositoryService {

    @GET("repositories")
    suspend fun getRepositories(): List<Repository>
}
