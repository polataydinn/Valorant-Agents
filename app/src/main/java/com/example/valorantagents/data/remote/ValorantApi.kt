package com.example.valorantagents.data.remote

import com.example.valorantagents.data.remote.dto.AgentsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ValorantApi {

    @GET("v1/agents")
    suspend fun getAllAgents(
        @Query("isPlayableCharacter") isPlayableCharacter: Boolean = true
    ): AgentsDto
}
