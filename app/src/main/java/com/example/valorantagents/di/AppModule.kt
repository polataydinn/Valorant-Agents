package com.example.valorantagents.di

import com.example.valorantagents.common.Constants
import com.example.valorantagents.data.remote.ValorantApi
import com.example.valorantagents.data.repository.ValorantRepositoryImpl
import com.example.valorantagents.domain.repository.ValorantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideValorantApi(): ValorantApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ValorantApi::class.java)
    }

    @Provides
    @Singleton
    fun provideValorantRepository(api: ValorantApi): ValorantRepository{
        return ValorantRepositoryImpl(api)
    }
}