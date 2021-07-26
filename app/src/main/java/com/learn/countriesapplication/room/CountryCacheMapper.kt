package com.learn.countriesapplication.room

import com.learn.countriesapplication.model.Country
import com.learn.countriesapplication.utils.EntityMapper
import javax.inject.Inject

class CountryCacheMapper @Inject constructor() : EntityMapper<CountryCacheEntity, Country> {

    override fun mapFromEntity(entity: CountryCacheEntity): Country {
        return Country(
            name = entity.name,
            capital = entity.capital,
            flag = entity.flag,
            region = entity.region,
            population = entity.population,
            area = entity.area
        )
    }

    override fun mapToEntity(domainModel: Country): CountryCacheEntity {
        return CountryCacheEntity(
            name = domainModel.name,
            capital = domainModel.capital,
            flag = domainModel.flag,
            area = domainModel.area,
            population = domainModel.population,
            region = domainModel.region
        )
    }

    fun mapFromEntityList(entities: List<CountryCacheEntity>): List<Country> {
        return entities.map { mapFromEntity(it) }
    }
}