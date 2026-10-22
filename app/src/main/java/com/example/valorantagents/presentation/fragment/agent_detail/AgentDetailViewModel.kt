package com.example.valorantagents.presentation.fragment.agent_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.valorantagents.common.Constants
import com.example.valorantagents.domain.model.Agents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AgentDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(AgentState())
    val state: StateFlow<AgentState> = _state.asStateFlow()

    init {
        getAgentDetail(savedStateHandle.get<Agents>(Constants.AGENT_ID))
    }

    private fun getAgentDetail(agent: Agents?) {
        _state.value = if (agent != null && agent.abilities.isNotEmpty()) {
            AgentState(agents = agent)
        } else {
            AgentState(error = "Agent details could not be loaded.")
        }
    }
}
