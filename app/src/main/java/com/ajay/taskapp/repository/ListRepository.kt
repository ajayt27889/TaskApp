package com.ajay.taskapp.repository

import com.ajay.taskapp.domain.Repository

interface ListRepository {
    suspend fun getRepositories(): List<Repository>
}
