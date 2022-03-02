package com.example.valorantagents.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Role(
    @SerializedName("assetPath")
    val assetPath: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("displayIcon")
    val displayIcon: String,
    @SerializedName("displayName")
    val displayName: String?,
    @SerializedName("uuid")
    val uuid: String
)