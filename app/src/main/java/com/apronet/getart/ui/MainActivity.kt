package com.apronet.getart.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.apronet.getart.ui.about.AboutScreen
import com.apronet.getart.ui.departments.DepartmentsScreen
import com.apronet.getart.ui.theme.GetartTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      GetartTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = NavRoute.Departments.route) {
          composable(NavRoute.Departments.pattern) {
            DepartmentsScreen(navController = navController, viewModel = hiltViewModel())
          }
          composable(NavRoute.About.pattern) {
            AboutScreen(hiltViewModel())
          }
        }
      }
    }
  }
}

