package com.example.valorantagents.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Ability(
    @SerializedName("description")
    val description: String,
    @SerializedName("displayIcon")
    val displayIcon: String?,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("slot")
    val slot: String
)
fun Ability.toAbility(): com.example.valorantagents.domain.model.Ability {
    return com.example.valorantagents.domain.model.Ability(
        displayName = displayName,
        description = description,
        displayIcon = displayIcon
    )
}
