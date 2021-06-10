package com.mob.covid19.di

import com.mob.covid19.api.VirusService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetWorkModule {

    @Singleton
    @Provides
    fun provideVirusService(): VirusService {
        return VirusService.create()
    }
}