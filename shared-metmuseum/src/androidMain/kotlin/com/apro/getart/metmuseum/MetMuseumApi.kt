package com.apro.getart.metmuseum

import com.apro.getart.metmuseum.model.DepartmentsResponse

interface MetMuseumApi {

    suspend fun departments(): DepartmentsResponse

    suspend fun fetchArtsByDepartmentId(departmentId: Int)
}