package com.apronet.getart.ui.departments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.apronet.getart.ui.theme.GetartTheme

@Composable
fun DepartmentsScreen(
  navController: NavHostController,
  viewModel: DepartmentsViewModel,
) {

  Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
    Greeting("Departments", viewModel)


  }
}

@Composable
private fun Greeting(name: String, viewModel: DepartmentsViewModel) {

Column() {


  Button(onClick = {
    viewModel.departmentsClicked()
  }){
    Text(text = "Hello $name!")
  }}



}

@Preview
@Composable
private fun DefaultPreview() {
  GetartTheme {
    Greeting("Android", hiltViewModel())
  }
}