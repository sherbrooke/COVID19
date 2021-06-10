package com.mob.covid19.data

import com.google.gson.annotations.SerializedName

data class CurrentData(
    @field:SerializedName("updated") val updated: Long, //时间
    @field:SerializedName("cases") val cases: Long,     //感染总数
    @field:SerializedName("todayCases") val todayCases: Int,//今日总数
    @field:SerializedName("deaths") val deaths: Long,//死亡总数
    @field:SerializedName("todayDeaths") val todayDeaths: Int,//今日死亡
    @field:SerializedName("recovered") val recovered: Long,//今日治愈
    @field:SerializedName("active") val active: Long,//
    @field:SerializedName("critical") val critical: Long,//
//    @field:SerializedName("casesPerOneMillion") val casesPerOneMillion: Float,//
//    @field:SerializedName("deathsPerOneMillion") val deathsPerOneMillion: Float,//
    @field:SerializedName("tests") val tests: Long,//
//    @field:SerializedName("testsPerOneMillion") val testsPerOneMillion: Float,//
    @field:SerializedName("affectedCountries") val affectedCountries: Int,//

)


//{
//    "updated": 1587140275989,
//    "cases": 2181308,
//    "todayCases": 95022,
//    "deaths": 145471,
//    "todayDeaths": 6996,
//    "recovered": 547069,
//    "active": 1488768,
//    "critical": 56602,
//    "casesPerOneMillion": 280,
//    "deathsPerOneMillion": 18,
//    "tests": 18215929,
//    "testsPerOneMillion": 2338.3,
//    "affectedCountries": 212
//}