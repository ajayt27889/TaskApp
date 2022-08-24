package com.ajay.taskapp.network

import com.ajay.taskapp.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryRemoteSource @Inject constructor(
    private val repositoryService: RepositoryService
) {
    suspend fun getRepositories(): List<Repository> =
        withContext(Dispatchers.IO) {
            repositoryService.getRepositories()
        }
}
