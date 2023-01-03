package com.apro.getart.metmuseum.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtData(
  @SerialName("total") val total: Int,
  @SerialName("objectIDs") val objectIDs: List<Int>,
)