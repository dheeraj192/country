package com.learn.countriesapplication.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.learn.countriesapplication.model.Country
import com.learn.countriesapplication.repository.CountryRepository
import com.learn.countriesapplication.utils.State
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class CountryViewModel @ViewModelInject constructor(
    private val countryRepository: CountryRepository): ViewModel() {
    private val _dataState: MutableLiveData<State<List<Country>>> = MutableLiveData()

    val dataState: LiveData<State<List<Country>>>
        get() = _dataState

    fun getCountries(region: String) {
        viewModelScope.launch {
            countryRepository.getCountries(region).onEach {
                _dataState.value = it
            }.launchIn(viewModelScope)
        }
    }
}