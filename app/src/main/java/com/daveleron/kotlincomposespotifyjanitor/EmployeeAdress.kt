package com.daveleron.kotlincomposespotifyjanitor

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class EmployeeAddress(
    @SerializedName("street")
val empStreet: String? = null,

@SerializedName("suite")
val empSuite: String? = null,

@SerializedName("city")
val empCity: String? = null,

@SerializedName("zipcode")
val empZipCode: String? = null

) : Serializable