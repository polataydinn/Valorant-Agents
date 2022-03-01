package com.example.valorantagents.domain.repository

import com.example.valorantagents.data.remote.dto.AgentsDto

interface ValorantRepository {

    suspend fun getAllAgents(): AgentsDto
}