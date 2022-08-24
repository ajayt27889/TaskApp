package com.ajay.taskapp.module

import com.ajay.taskapp.repository.ListRepository
import com.ajay.taskapp.usecases.MainUseCase
import com.ajay.taskapp.usecases.MainUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {
    @Provides
    @ViewModelScoped
    fun provideMainUseCase(
        listRepository: ListRepository,
    ): MainUseCase = MainUseCaseImpl(listRepository)

}