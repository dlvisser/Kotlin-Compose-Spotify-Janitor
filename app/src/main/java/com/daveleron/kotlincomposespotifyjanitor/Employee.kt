package com.daveleron.kotlincomposespotifyjanitor

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Employee(

    @SerializedName("id")
val empId: Int? = null,

@SerializedName("name")
val empName: String? = null,

@SerializedName("username")
val empUserName: String? = null,

@SerializedName("email")
val empEmail: String? = null,

@SerializedName("address")
val empAddressObject: EmployeeAddress? = null,

@SerializedName("phone")
val empPhone: String? = null,

@SerializedName("website")
val empWebsite: String? = null
) : Serializable