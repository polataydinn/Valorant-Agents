package com.example.valorantagents.domain.model

import java.util.*

data class Agents(
    val uuid: String,
    val displayName: String,
    val role: String?,
    val fullPortrait: String,
    val background: String?,
    val agentRoleIcon: String
)