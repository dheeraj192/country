package com.learn.countriesapplication.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(countryEntity: CountryCacheEntity): Long

    @Query("SELECT * FROM country")
    suspend fun get(): List<CountryCacheEntity>
}