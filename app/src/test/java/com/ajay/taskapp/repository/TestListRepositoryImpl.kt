package com.ajay.taskapp.repository

import com.ajay.taskapp.domain.Repository

class TestListRepositoryImpl: ListRepository {
    override suspend fun getRepositories(): List<Repository> {
        return  emptyList<Repository>().toMutableList().apply {
            add(Repository(1,"dummy1","dummy1 description"))
            add(Repository(2,"dummy2","dummy2 description"))
        }
    }

}