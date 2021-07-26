package com.learn.countriesapplication.repository

import com.learn.countriesapplication.model.Country
import com.learn.countriesapplication.retrofit.CountryNetworkMapper
import com.learn.countriesapplication.retrofit.CountryRetrofit
import com.learn.countriesapplication.room.CountryCacheMapper
import com.learn.countriesapplication.room.CountryDao
import com.learn.countriesapplication.utils.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CountryRepository constructor(
    private val blogDao: CountryDao,
    private val blogRetrofit: CountryRetrofit,
    private val cacheMapper: CountryCacheMapper,
    private val networkMapper: CountryNetworkMapper
) {
    fun getCountries(region: String): Flow<State<List<Country>>> = flow {
        emit(State.Loading)
        try {
            val networkBlogs = blogRetrofit.get(region)
            val blogs = networkMapper.mapFromEntityList(networkBlogs)
            for (blog in blogs) {
                blogDao.insert(cacheMapper.mapToEntity(blog))
            }
            val cachedBlogs = blogDao.get()
            emit(State.Success(cacheMapper.mapFromEntityList(cachedBlogs)))
        } catch (e: Exception) {
            emit(State.Error(e))
        }
    }
}