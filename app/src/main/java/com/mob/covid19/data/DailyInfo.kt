package com.mob.covid19.data

data class DailyInfo(
    val date: Long, //时间
    val country: String, //国家
    val infect: Int, //感染
    val death: Int, //死亡
    val cure: Int, //治愈

) {
}



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