package com.learn.countriesapplication.ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.learn.countriesapplication.R
import com.learn.countriesapplication.model.Country
import com.learn.countriesapplication.utils.State
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountriesActivity : AppCompatActivity() {

    private val viewModel: CountryViewModel by viewModels()
    private lateinit var countryText: TextView
    private lateinit var circularProgress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        circularProgress = findViewById(R.id.progressCircular)
        countryText = findViewById(R.id.countriesList)
        setObservers()
        viewModel.getCountries("Asia")
    }

    private fun setObservers() {
        viewModel.dataState.observe(this, { state ->
            when (state) {
                is State.Success<List<Country>> -> {
                    val countryStringBuilder = StringBuilder()
                    state.data.forEach { country ->
                        countryStringBuilder.append(country.name).append("\n")
                    }
                    countryText.text = countryStringBuilder.toString()
                    circularProgress.visibility = View.GONE
                }
                is State.Error -> {
                    countryText.text = getString(R.string.load_error)
                    circularProgress.visibility = View.GONE
                }
                is State.Loading -> {
                    circularProgress.visibility = View.VISIBLE
                }
            }
        })
    }
}