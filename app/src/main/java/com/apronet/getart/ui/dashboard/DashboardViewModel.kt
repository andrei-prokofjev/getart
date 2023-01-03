package com.apronet.getart.ui.dashboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.apro.getart.metmuseum.model.DepartmentData
import com.apronet.getart.data.DefaultMetMuseumRepository
import com.apronet.getart.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
  private val metMuseumRepository: DefaultMetMuseumRepository,
) : BaseViewModel() {

  var departments by mutableStateOf(emptyList<DepartmentData>())
    private set

  init {
    viewModelScope.launch(exceptionHandler) {
      departments = metMuseumRepository.departments().departments
    }
  }

  fun departmentClicked(department: DepartmentData) {
    viewModelScope.launch(exceptionHandler) {
      metMuseumRepository.fetchObjectsByDepartmentId(department.departmentId)
    }
  }
}