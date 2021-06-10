package com.mob.covid19.api

import com.mob.covid19.data.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.http.GET
import retrofit2.http.Path

interface VirusService {

    @GET("all")
    suspend fun getAll(): CurrentData

    @GET("countries")
    suspend fun countries():List<Country>

    @GET("historical/{country}/{province}")
    suspend fun historicalWithCountryProvince(@Path("country") country: String,@Path("province") province: String): CountryProvinceHistorical


    @GET("historical/{country}")
    suspend fun historicalWithCountry(@Path("country") country: String): CountryHistorical

    @GET("historical")
    suspend fun historical(): List<CountryProvinceHistorical>

    @GET("historical/all")
    suspend fun historicalAll(): Historical

    companion object {
        private const val BASE_URL = "https://corona.lmao.ninja/v2/"

        fun create(): VirusService {
            val logger = HttpLoggingInterceptor().apply { level = Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(VirusService::class.java)
        }
    }
}