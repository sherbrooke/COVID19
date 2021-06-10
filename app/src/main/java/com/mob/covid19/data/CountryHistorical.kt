package com.mob.covid19.data

import com.google.gson.annotations.SerializedName

data class CountryHistorical(
    @field:SerializedName("country") val country: String,
    @field:SerializedName("provinces") val provinces: List<String>,
    @field:SerializedName("timeline") val timeline: Timeline
)


data class Timeline(
    @field:SerializedName("cases")  val cases: Map<String, Int>,
    @field:SerializedName("deaths")  val deaths: Map<String, Int>,
    @field:SerializedName("recovered")  val recovered: Map<String, Int>
)
