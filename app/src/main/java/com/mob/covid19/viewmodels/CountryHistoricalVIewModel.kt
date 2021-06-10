package com.mob.covid19.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mob.covid19.data.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryHistoricalVIewModel @Inject constructor(var repository: CurrentDataSource) :
    ViewModel() {

    private var historical: MutableLiveData<CountryHistorical>? = null

    fun initCountryHistoricalData(country: String) {
        if (historical == null) {
            historical = MutableLiveData()
        }
        GlobalScope.launch {
            historical!!.postValue(repository.historicalWithCountry(country))
        }
    }

    fun getCountryHistorical(): MutableLiveData<CountryHistorical>? {
        return historical
    }

}