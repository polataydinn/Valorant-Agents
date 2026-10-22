package com.example.valorantagents.data.repository

import com.example.valorantagents.data.remote.ValorantApi
import com.example.valorantagents.data.remote.dto.toAgents
import com.example.valorantagents.domain.model.Agents
import com.example.valorantagents.domain.repository.ValorantRepository
import javax.inject.Inject

class ValorantRepositoryImpl @Inject constructor(
    private val api: ValorantApi
): ValorantRepository {
    override suspend fun getPlayableAgents(): List<Agents> {
        return api.getAllAgents(isPlayableCharacter = true).data
            .filter { it.background != null }
            .map { it.toAgents() }
    }

}
