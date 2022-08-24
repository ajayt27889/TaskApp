package com.ajay.taskapp.usecases

import com.ajay.taskapp.repository.ListRepository
import com.ajay.taskapp.repository.TestListRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class MainUseCaseImplTest {
    lateinit var listRepository: ListRepository
    lateinit var mainUseCase: MainUseCase

    @Before
    fun setUp() {
        listRepository = TestListRepositoryImpl()
        mainUseCase = MainUseCaseImpl(listRepository)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `Test getRepositories check size non empty`() = runBlocking {
        assertEquals(true, mainUseCase.getRepositories().isEmpty().not())
    }

}