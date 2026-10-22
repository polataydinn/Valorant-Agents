package com.example.valorantagents.presentation.fragment.agent_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantagents.common.Resource
import com.example.valorantagents.domain.use_case.get_agents.GetAgentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AgentListViewModel @Inject constructor(
    private val getAgentsUseCase: GetAgentsUseCase
) : ViewModel(){
    private val _state = MutableStateFlow(AgentListState())
    val state: StateFlow<AgentListState> = _state.asStateFlow()

    private var getAgentsJob: Job? = null

    init {
        getAgents()
    }

    fun getAgents() {
        getAgentsJob?.cancel()
        getAgentsJob = getAgentsUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    // Shuffle once per load so the order stays stable across configuration changes
                    _state.value = AgentListState(agents = result.data.orEmpty().shuffled())
                }
                is Resource.Error -> {
                    _state.value = AgentListState(error = result.message ?:
                    "An unexpected error occurred.")
                }
                is Resource.Loading -> {
                    _state.value = AgentListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
