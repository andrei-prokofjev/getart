package com.apronet.getart.data

import com.apro.getart.metmuseum.MetMuseum
import com.apro.getart.metmuseum.model.DepartmentsResponse
import com.apronet.getart.di.DispatchersIO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultMetMuseumRepository @Inject constructor(
  private val metMuseum: MetMuseum,
  @DispatchersIO val ioDispatcher: CoroutineDispatcher,
) : MetMuseumRepository {

  override suspend fun departments(): DepartmentsResponse {
    return withContext(ioDispatcher) {
      metMuseum.api.departments()
    }
  }

}