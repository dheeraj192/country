package com.learn.countriesapplication.di

import com.learn.countriesapplication.repository.CountryRepository
import com.learn.countriesapplication.retrofit.CountryNetworkMapper
import com.learn.countriesapplication.retrofit.CountryRetrofit
import com.learn.countriesapplication.room.CountryCacheMapper
import com.learn.countriesapplication.room.CountryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCountryRepository(
        blogDao: CountryDao,
        retrofit: CountryRetrofit,
        cacheMapper: CountryCacheMapper,
        networkMapper: CountryNetworkMapper
    ): CountryRepository{
        return CountryRepository(blogDao, retrofit, cacheMapper, networkMapper)
    }
}