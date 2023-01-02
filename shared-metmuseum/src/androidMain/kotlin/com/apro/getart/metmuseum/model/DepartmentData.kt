package com.apro.getart.metmuseum.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DepartmentsResponse(
    @SerialName("departments") val departments: List<DepartmentData>,
)

@Serializable
data class DepartmentData(
    @SerialName("departmentId") val departmentId: Int,
    @SerialName("displayName") val displayName: String,
)
