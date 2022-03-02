package com.example.valorantagents.presentation.fragment.agent_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantagents.common.Resource
import com.example.valorantagents.domain.use_case.get_agents.GetAgentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AgentListViewModel @Inject constructor(
    private val getAgentsUseCase: GetAgentsUseCase
) : ViewModel(){
    private val _state = MutableStateFlow(AgentListState())
    val state: StateFlow<AgentListState> = _state

    init {
        getAgents()
    }

    private fun getAgents() {
        getAgentsUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = AgentListState(agents = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = AgentListState(error = result.message ?:
                    "An unexpected error occured.")
                }
                is Resource.Loading -> {
                    _state.value = AgentListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}