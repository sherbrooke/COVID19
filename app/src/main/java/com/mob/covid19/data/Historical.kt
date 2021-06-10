package com.mob.covid19.data

import com.google.gson.annotations.SerializedName

data class Historical(
    @field:SerializedName("cases") val cases: Map<String, Long>,
    @field:SerializedName("deaths") val deaths: Map<String, Long>,
    @field:SerializedName("recovered") val recovered: Map<String, Long>
)


data class HistoricalWithDate(
    var case: Long,
    var death: Long,
    var recovered: Long,
    var date: String
)