package com.example.valorantagents.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Agents(
    val uuid: String,
    val displayName: String,
    val role: String?,
    val fullPortrait: String,
    val background: String?,
    val agentRoleIcon: String?,
    val abilities: List<Ability>,
    val bustPortrait: String,
    val description: String
) : Parcelable
