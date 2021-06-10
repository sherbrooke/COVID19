package com.mob.covid19.data

import com.google.gson.annotations.SerializedName

data class Country(
    @field:SerializedName("updated") val updated: Long,
    @field:SerializedName("country") val country: String,
    @field:SerializedName("countryInfo") val countryInfo: CountryInfo,
    @field:SerializedName("cases") val cases: Long,
    @field:SerializedName("todayCases") val todayCases: Int,
    @field:SerializedName("deaths") val deaths: Int,
    @field:SerializedName("todayDeaths") val todayDeaths: Int,
    @field:SerializedName("recovered") val recovered: Int,
    @field:SerializedName("todayRecovered") val todayRecovered: Int,
    @field:SerializedName("active") val active: Int,
    @field:SerializedName("critical") val critical: Int,
//    @field:SerializedName("casesPerOneMillion") val casesPerOneMillion: Float,
//    @field:SerializedName("deathsPerOneMillion") val deathsPerOneMillion: Float,
    @field:SerializedName("tests") val tests: Int,
//    @field:SerializedName("testsPerOneMillion") val testsPerOneMillion: Float,
    @field:SerializedName("population") val population: Int,
    @field:SerializedName("continent") val continent: String, //国家名
//    @field:SerializedName("oneCasePerPeople") val oneCasePerPeople: Int,
//    @field:SerializedName("oneDeathPerPeople") val oneDeathPerPeople: Int,
//    @field:SerializedName("oneTestPerPeople") val oneTestPerPeople: Int,
    @field:SerializedName("undefined") val undefined: Int,
//    @field:SerializedName("activePerOneMillion") val activePerOneMillion: Float,
//    @field:SerializedName("recoveredPerOneMillion") val recoveredPerOneMillion: Float,
//    @field:SerializedName("criticalPerOneMillion") val criticalPerOneMillion: Float,

)


data class CountryInfo(
    @field:SerializedName("_id") val _id: Int,
    @field:SerializedName("iso2") val iso2: String,
    @field:SerializedName("iso3") val iso3: String,
    @field:SerializedName("lat") val lat: Float,
    @field:SerializedName("long") val long: Int,
    @field:SerializedName("flag") val flag: String,
)

//"updated":1623239282932,
//"country":"Bahamas",
//"countryInfo":{
//    "_id":44,
//    "iso2":"BS",
//    "iso3":"BHS",
//    "lat":24.25,
//    "long":-76,
//    "flag":"https://disease.sh/assets/img/flags/bs.png"
//},
//"cases":12024,
//"todayCases":0,
//"deaths":232,
//"todayDeaths":0,
//"recovered":11026,
//"todayRecovered":0,
//"active":766,
//"critical":3,
//"casesPerOneMillion":30306,
//"deathsPerOneMillion":585,
//"tests":100093,
//"testsPerOneMillion":252279,
//"population":396755,
//"continent":"North America",
//"oneCasePerPeople":33,
//"oneDeathPerPeople":1710,
//"oneTestPerPeople":4,
//"undefined":1931,
//"activePerOneMillion":1930.66,
//"recoveredPerOneMillion":27790.45,
//"criticalPerOneMillion":7.56
//},