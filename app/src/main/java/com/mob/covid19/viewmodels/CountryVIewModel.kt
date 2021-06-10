package com.mob.covid19.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mob.covid19.data.Country
import com.mob.covid19.data.CurrentData
import com.mob.covid19.data.CurrentDataSource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class CountryVIewModel @Inject constructor(var repository: CurrentDataSource): ViewModel() {

    private var countries: MutableLiveData<List<Country>>? = null

    fun initCountryData() {
        if (countries == null) {
            countries = MutableLiveData()
        }
        GlobalScope.launch {
            countries!!.postValue( repository.counties())
        }
    }

    fun getCountry(): MutableLiveData<List<Country>>? {
        return countries
    }

}