package com.example.valorantagents.domain.use_case.get_agents

import com.example.valorantagents.common.Resource
import com.example.valorantagents.data.remote.dto.toAgents
import com.example.valorantagents.domain.model.Agents
import com.example.valorantagents.domain.repository.ValorantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetAgentsUseCase @Inject constructor(
    private val repository: ValorantRepository
){
    operator fun invoke(): Flow<Resource<List<Agents>>> = flow {
        try {
            emit(Resource.Loading<List<Agents>>())
            val agents = repository.getAllAgents().data
            emit(Resource.Success<List<Agents>>(agents.map { it.toAgents() }))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Agents>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Agents>>("Couldn't reach server check your internet connection"))
        }
    }

}