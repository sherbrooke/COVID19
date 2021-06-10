package com.mob.covid19.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mob.covid19.data.Country
import com.mob.covid19.data.CountryProvinceHistorical
import com.mob.covid19.data.CurrentData
import com.mob.covid19.data.CurrentDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryProvinceVIewModel @Inject constructor(var repository: CurrentDataSource): ViewModel() {

    private var historical: MutableLiveData<CountryProvinceHistorical>? = null

    fun initCountryData(country: String, province: String) {
        if (historical == null) {
            historical = MutableLiveData()
        }
        GlobalScope.launch {
            historical!!.postValue( repository.historicalWithCountryProvince(country, province))
        }
    }

    fun getCountryProvinceHistorical(): MutableLiveData<CountryProvinceHistorical>? {
        return historical
    }

}