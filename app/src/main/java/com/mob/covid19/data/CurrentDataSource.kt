package com.mob.covid19.data

import android.util.Log
import com.mob.covid19.api.VirusService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.internal.notify
import okhttp3.internal.wait
import java.util.*
import javax.inject.Inject

class CurrentDataSource @Inject constructor(private val service: VirusService){
     suspend fun getAll(): CurrentData{
        return  service.getAll()
    }

    suspend fun counties(): List<Country> {
        return service.countries()
    }

    suspend fun historicalWithCountryProvince(country: String, province: String): CountryProvinceHistorical{
        return service.historicalWithCountryProvince(country , province )
    }

    suspend fun historicalWithCountry(country: String): CountryHistorical{
        return service.historicalWithCountry(country)
    }

    suspend fun historical(): List<CountryProvinceHistorical>{
        return service.historical()
    }
}