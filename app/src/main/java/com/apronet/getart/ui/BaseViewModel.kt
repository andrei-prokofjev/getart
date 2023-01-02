package com.apronet.getart.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

  private val _errorEvent = MutableSharedFlow<Throwable>()
  val errorEvent = _errorEvent.asSharedFlow()

  private val _toastMessage = MutableSharedFlow<String>()
  val toastMessage = _toastMessage.asSharedFlow()

  protected open val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
    viewModelScope.launch { _errorEvent.emit(throwable) }
  }

  protected fun showToast(message: String) {
    viewModelScope.launch(exceptionHandler) {
      _toastMessage.emit(message)
    }
  }
}