package com.example.valorantagents.data.remote.dto


import com.example.valorantagents.domain.model.Agents
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("abilities")
    val abilities: List<Ability>,
    @SerializedName("assetPath")
    val assetPath: String,
    @SerializedName("background")
    val background: String?,
    @SerializedName("bustPortrait")
    val bustPortrait: String,
    @SerializedName("characterTags")
    val characterTags: List<String>?,
    @SerializedName("description")
    val description: String,
    @SerializedName("developerName")
    val developerName: String,
    @SerializedName("displayIcon")
    val displayIcon: String,
    @SerializedName("displayIconSmall")
    val displayIconSmall: String,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("fullPortrait")
    val fullPortrait: String,
    @SerializedName("isAvailableForTest")
    val isAvailableForTest: Boolean,
    @SerializedName("isBaseContent")
    val isBaseContent: Boolean,
    @SerializedName("isFullPortraitRightFacing")
    val isFullPortraitRightFacing: Boolean,
    @SerializedName("isPlayableCharacter")
    val isPlayableCharacter: Boolean,
    @SerializedName("killfeedPortrait")
    val killfeedPortrait: String,
    @SerializedName("role")
    val role: Role,
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("voiceLine")
    val voiceLine: VoiceLine
)

fun Data.toAgents(): Agents{
    return Agents(
        uuid = uuid,
        displayName = displayName,
        role = role.displayName,
        fullPortrait = fullPortrait,
        background = background,
        agentRoleIcon = role.displayIcon
    )
}