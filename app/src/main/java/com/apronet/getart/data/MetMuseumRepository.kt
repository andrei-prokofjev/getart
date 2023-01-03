package com.apronet.getart.data

import com.apro.getart.metmuseum.model.DepartmentsResponse

interface MetMuseumRepository {

  suspend fun departments(): DepartmentsResponse

  suspend fun fetchObjectsByDepartmentId(departmentId: Int)
}