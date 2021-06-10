package com.mob.covid19

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class OwnApplication : Application() {
}


// TODO: 2021/6/9 请求到的数据存一份到数据库中去,这样就不用每次都去请求网络
// TODO: 2021/6/9 后台刷一遍数据，wifi情况下 ，每个省份的数据，每个国家的数据，每日数据