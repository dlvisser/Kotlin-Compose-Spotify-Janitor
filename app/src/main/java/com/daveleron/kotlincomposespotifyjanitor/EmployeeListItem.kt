package com.daveleron.kotlincomposespotifyjanitor

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EmployeeListItem(employee: Employee){
    Card(
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 12.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        elevation = 5.dp
    ) {
        val empAddressObject = remember {
            employee.empAddressObject
        }
        Column(
            modifier = Modifier.padding(all = 15.dp)
        ) {
            employee.empName?.let { Text(it, fontSize = 22.sp) }
            Text(employee.empUserName + " | " + employee.empEmail)
            Text(employee.empPhone + " | " + employee.empWebsite)
            Text(empAddressObject?.empSuite + "," + empAddressObject?.empStreet + "," + empAddressObject?.empCity + "," + empAddressObject?.empZipCode)
        }
    }
}

@Preview
@Composable
fun EmployeeListPreview(){
    EmployeeListItem(employee = Employee(empId = 1, empName = "Jan", empUserName = "Jan Klaas", empEmail = "jan@jan.nl"))
}