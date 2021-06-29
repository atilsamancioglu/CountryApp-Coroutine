package com.atilsamancioglu.countryapp.service

import com.atilsamancioglu.countryapp.model.Country
import retrofit2.Response
import retrofit2.http.GET

interface CountryAPI {
    //https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json

    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    suspend fun getCountries(): Response<List<Country>>

}