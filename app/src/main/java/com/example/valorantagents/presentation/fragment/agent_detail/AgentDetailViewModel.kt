package com.example.valorantagents.presentation.fragment.agent_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.valorantagents.common.Constants
import com.example.valorantagents.domain.model.Agents
import com.example.valorantagents.presentation.fragment.agent_list.AgentListState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class AgentDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(AgentState())
    val state: StateFlow<AgentState> = _state

    init {
        savedStateHandle.get<Agents>(Constants.AGENT_ID)?.let { agent ->
            getAgentDetail(agent)
        }
    }

    private fun getAgentDetail(agent: Agents) {
        if (!agent.abilities.isNullOrEmpty()){
            _state.value = AgentState(agents = agent)
        }else{
            _state.value = AgentState(error = "Hata!")
        }
    }
}