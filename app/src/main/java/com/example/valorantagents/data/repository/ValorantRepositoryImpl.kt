package com.example.valorantagents.data.repository

import com.example.valorantagents.data.remote.ValorantApi
import com.example.valorantagents.data.remote.dto.AgentsDto
import com.example.valorantagents.domain.repository.ValorantRepository
import javax.inject.Inject

class ValorantRepositoryImpl @Inject constructor(
    private val api: ValorantApi
): ValorantRepository {
    override suspend fun getAllAgents(): AgentsDto {
        return api.getAllAgents()
    }

}