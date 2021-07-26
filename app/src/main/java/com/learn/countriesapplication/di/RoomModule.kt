package com.learn.countriesapplication.di

import android.content.Context
import androidx.room.Room
import com.learn.countriesapplication.room.CountryDao
import com.learn.countriesapplication.room.CountryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideCountryDb(@ApplicationContext context: Context): CountryDatabase {
        return Room
            .databaseBuilder(
                context,
                CountryDatabase::class.java,
                CountryDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideCountryDAO(blogDatabase: CountryDatabase): CountryDao {
        return blogDatabase.getCountryDao()
    }
}