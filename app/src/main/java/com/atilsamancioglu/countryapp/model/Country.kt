package com.atilsamancioglu.countryapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Country(
    @SerializedName("name")
    val countryName : String?,
    @SerializedName("capital")
    val countryCapital : String?,
    @SerializedName("region")
    val countryRegion : String?,
    @SerializedName("currency")
    val countryCurrency : String?,
    @SerializedName("language")
    val countryLanguage : String?,
    @SerializedName("flag")
    val imageUrl : String?
) : Serializable
