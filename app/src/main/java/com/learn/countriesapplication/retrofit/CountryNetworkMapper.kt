package com.learn.countriesapplication.retrofit

import com.learn.countriesapplication.model.Country
import com.learn.countriesapplication.utils.EntityMapper
import javax.inject.Inject

class CountryNetworkMapper @Inject constructor() : EntityMapper<CountryNetworkEntity, Country> {

    override fun mapFromEntity(entity: CountryNetworkEntity): Country {
        return Country(
            name = entity.name,
            capital = entity.capital,
            flag = entity.flag,
            region = entity.region,
            population = entity.population,
            area = entity.area
        )
    }

    override fun mapToEntity(domainModel: Country): CountryNetworkEntity {
        return CountryNetworkEntity(
            name = domainModel.name,
            capital = domainModel.capital,
            flag = domainModel.flag,
            region = domainModel.region,
            population = domainModel.population,
            area = domainModel.area
        )
    }

    fun mapFromEntityList(entities: List<CountryNetworkEntity>): List<Country> {
        return entities.map { mapFromEntity(it) }
    }

}