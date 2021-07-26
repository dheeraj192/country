package com.learn.countriesapplication.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CountryCacheEntity::class ], version = 1, exportSchema = false)
abstract class CountryDatabase: RoomDatabase() {
    abstract fun getCountryDao(): CountryDao

    companion object{
        val DATABASE_NAME: String = "country_db"
    }
}