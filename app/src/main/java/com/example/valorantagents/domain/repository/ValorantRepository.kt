package com.example.valorantagents.domain.repository

import com.example.valorantagents.domain.model.Agents

interface ValorantRepository {

    suspend fun getPlayableAgents(): List<Agents>
}
