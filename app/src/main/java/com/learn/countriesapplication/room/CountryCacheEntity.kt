package com.learn.countriesapplication.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country")
class CountryCacheEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "capitol")
    var capital: String,

    @ColumnInfo(name = "flag")
    var flag: String,

    @ColumnInfo(name = "region")
    var region: String,

    @ColumnInfo(name = "population")
    var population: Long,

    @ColumnInfo(name = "area")
    var area: Long
)