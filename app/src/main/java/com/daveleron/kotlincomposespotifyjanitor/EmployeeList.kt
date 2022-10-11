package com.daveleron.kotlincomposespotifyjanitor

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@Composable
fun EmployeesList(listEmployees: MutableList<Employee>){

    LazyColumn(){
        items(
            items = listEmployees,
            itemContent = { EmployeeListItem(employee = it) }
        )
    }

}