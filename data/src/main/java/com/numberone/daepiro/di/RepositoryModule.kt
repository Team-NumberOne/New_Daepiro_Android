package com.numberone.daepiro.di

import com.numberone.daepiro.repository.DataStoreRepository
import com.numberone.daepiro.repository.DataStoreRepositoryImpl
import com.numberone.daepiro.repository.UserRepository
import com.numberone.daepiro.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository

    @Binds
    @Singleton
    abstract fun provideDataStoreRepository(
        dataStoreRepositoryImpl: DataStoreRepositoryImpl
    ): DataStoreRepository

}