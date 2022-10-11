package com.daveleron.kotlincomposespotifyjanitor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class EmployeeViewModel() : ViewModel() {
    fun getEmployeesData() = liveData(Dispatchers.IO) {
        emit(MyApiResponse.loading(data = null))
        try {
            emit(MyApiResponse.success(data = MyApiClient.MY_API_SERVICE.getEmployees()))
        } catch (exception: Exception) {
            emit(MyApiResponse.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}