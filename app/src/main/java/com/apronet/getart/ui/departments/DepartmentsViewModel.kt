package com.apronet.getart.ui.departments

import androidx.lifecycle.viewModelScope
import com.apronet.getart.data.DefaultMetMuseumRepository
import com.apronet.getart.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DepartmentsViewModel @Inject constructor(
  private val metMuseumRepository: DefaultMetMuseumRepository,
) : BaseViewModel() {

  fun departmentsClicked() {

    viewModelScope.launch(exceptionHandler) {
      val departments = metMuseumRepository.departments()

      println(">>> " + departments.departments.joinToString{it.displayName})

    }


  }
}