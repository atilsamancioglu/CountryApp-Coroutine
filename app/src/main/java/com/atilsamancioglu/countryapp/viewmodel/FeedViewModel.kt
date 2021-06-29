package com.atilsamancioglu.countryapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atilsamancioglu.countryapp.model.Country
import com.atilsamancioglu.countryapp.service.CountryAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FeedViewModel : ViewModel() {

    var job : Job? = null

    val countries = MutableLiveData<List<Country>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()

    fun downloadData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountryAPI::class.java)

        countryLoading.value = true
        job = viewModelScope.launch(context = Dispatchers.IO) {

            val response = retrofit.getCountries()

            withContext(Dispatchers.Main) {

                if(response.isSuccessful) {
                    response.body()?.let {
                        countries.value = it
                        countryLoading.value = false
                    }
                } else {
                    countryError.value = true
                    countryLoading.value = false
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}