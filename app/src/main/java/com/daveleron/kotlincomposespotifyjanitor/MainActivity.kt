package com.daveleron.kotlincomposespotifyjanitor

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.Observer
import com.daveleron.kotlincomposespotifyjanitor.ui.theme.KotlinComposeSpotifyJanitorTheme

class MainActivity : ComponentActivity() {

    private var getListEmployees: MutableList<Employee> by mutableStateOf(mutableListOf())
    private var isLoading: Boolean by mutableStateOf(false)
    private val employeeViewModel by viewModels<EmployeeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinComposeSpotifyJanitorTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainActivityLayout(getEmployeesList = getListEmployees, isLoading = isLoading)
                }
            }
        }
        employeeViewModel.getEmployeesData().observe(this, Observer { it ->
            it.let { myApiResponse ->
                when (myApiResponse.myApiStatus) {
                    MyApiStatus.SUCCESS -> {
                        myApiResponse.data?.let { it ->
                            getListEmployees.clear()
                            getListEmployees.addAll(it)
                            isLoading = false
                        }
                    }
                    MyApiStatus.ERROR -> {
                        isLoading = false
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    MyApiStatus.LOADING -> {
                        isLoading = true
                    }
                }
            }
        })
    }
}

@Composable
fun MainActivityLayout(getEmployeesList : MutableList<Employee>, isLoading: Boolean) {
    if(isLoading){
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator()
        }
    } else {
        EmployeesList(listEmployees = getEmployeesList)
    }
}