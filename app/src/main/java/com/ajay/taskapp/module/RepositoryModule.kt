package com.ajay.taskapp.module

import com.ajay.taskapp.network.RepositoryRemoteSource
import com.ajay.taskapp.repository.ListRepository
import com.ajay.taskapp.repository.ListRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideListRepository(
        repositoryRemoteSource: RepositoryRemoteSource,
    ): ListRepository = ListRepositoryImpl(repositoryRemoteSource)

}
