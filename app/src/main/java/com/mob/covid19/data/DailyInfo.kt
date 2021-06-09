package com.mob.covid19.data

data class DailyInfo(
    val date: String, //日期
    val country: String, //国家
    val infect: Int, //感染
    val death: Int, //死亡
    val cure: Int, //治愈
) {
}