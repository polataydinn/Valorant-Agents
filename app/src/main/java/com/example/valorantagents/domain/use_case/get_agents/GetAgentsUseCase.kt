package com.example.valorantagents.domain.use_case.get_agents

import com.example.valorantagents.common.Resource
import com.example.valorantagents.domain.model.Agents
import com.example.valorantagents.domain.repository.ValorantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAgentsUseCase @Inject constructor(
    private val repository: ValorantRepository
){
    operator fun invoke(): Flow<Resource<List<Agents>>> = flow {
        try {
            emit(Resource.Loading<List<Agents>>())
            emit(Resource.Success<List<Agents>>(repository.getPlayableAgents()))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Agents>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Agents>>("Couldn't reach server. Check your internet connection."))
        }
    }

}
