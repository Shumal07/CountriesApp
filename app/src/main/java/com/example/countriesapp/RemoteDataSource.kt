package com.example.countriesapp


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface RestCountriesApi {
  @GET("name/{name}")
  suspend fun getCountryByName(@Path("name") cityName: String?): List<Country>
}

var retrofit = Retrofit.Builder()
  .baseUrl("https://restcountries.com/v3.1/")
  .addConverterFactory(GsonConverterFactory.create())
  .build()

var restCountriesApi = retrofit.create(RestCountriesApi::class.java)