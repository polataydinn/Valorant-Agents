package com.example.valorantagents.presentation.fragment.agent_list

import com.example.valorantagents.domain.model.Agents

data class AgentListState(
    val isLoading: Boolean? = false,
    val agents: List<Agents>? = emptyList(),
    val error: String = ""
)
