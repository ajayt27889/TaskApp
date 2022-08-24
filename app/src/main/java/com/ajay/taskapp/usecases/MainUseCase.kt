package com.ajay.taskapp.usecases

import com.ajay.taskapp.domain.Repository
import com.ajay.taskapp.repository.ListRepository
import javax.inject.Inject

interface MainUseCase {
    suspend fun getRepositories(): List<Repository>
}

class MainUseCaseImpl @Inject constructor(
    private val listRepository: ListRepository
) : MainUseCase {
    override suspend fun getRepositories(): List<Repository> {
        return listRepository.getRepositories()

    }
}