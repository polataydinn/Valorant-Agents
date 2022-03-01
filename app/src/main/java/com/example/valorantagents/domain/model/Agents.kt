package com.example.valorantagents.domain.model

import java.util.*

data class Agents(
    val uuid: String,
    val displayName: String,
    val description: String,
    val displayIcon: String,
    val characterTags: List<String>?
)