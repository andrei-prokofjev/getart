package com.apronet.getart.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.apronet.getart.ui.theme.GetartTheme

@Composable
fun DepartmentsScreen(
  navController: NavHostController,
  viewModel: DashboardViewModel,
) {
  Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
    DepartmentsDropDownMenu(viewModel)

  }
}


@Composable
fun DepartmentsDropDownMenu(
  viewModel: DashboardViewModel,
) {
  var expanded by remember { mutableStateOf(false) }
  val items = viewModel.departments

  var selectedIndex by remember { mutableStateOf(0) }
  Box(modifier = Modifier
    .fillMaxWidth()
    .wrapContentSize(Alignment.TopStart)) {
    if (items.isNotEmpty()) {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .height(40.dp)

          .clickable(onClick = { expanded = true })
      ) {
        Text(
          text = items[selectedIndex].displayName,
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .align(Alignment.CenterStart)
        )
      }
    }
    DropdownMenu(
      expanded = expanded,
      onDismissRequest = { expanded = false },
      modifier = Modifier.fillMaxWidth()
    ) {
      items.forEachIndexed { index, department ->
        DropdownMenuItem(
          text = { Text(text = department.displayName) },
          onClick = {
            selectedIndex = index
            expanded = false
            viewModel.departmentClicked(department)
          },
        )
      }
    }
  }
}

