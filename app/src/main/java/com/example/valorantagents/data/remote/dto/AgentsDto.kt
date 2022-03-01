package com.example.valorantagents.data.remote.dto


import com.example.valorantagents.domain.model.Agents
import com.google.gson.annotations.SerializedName

data class AgentsDto(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("status")
    val status: Int
)

