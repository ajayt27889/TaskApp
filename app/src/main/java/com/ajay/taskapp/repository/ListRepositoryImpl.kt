package com.ajay.taskapp.repository

import com.ajay.taskapp.domain.Repository
import com.ajay.taskapp.network.RepositoryRemoteSource
import javax.inject.Inject

class ListRepositoryImpl
@Inject constructor(
    private val repositoryRemoteSource: RepositoryRemoteSource
) : ListRepository {

    override suspend fun getRepositories(): List<Repository> {
        return repositoryRemoteSource.getRepositories()
    }
}
