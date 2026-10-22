package com.example.valorantagents.presentation.fragment.agent_detail

import com.example.valorantagents.domain.model.Agents

data class AgentState(
    val agents: Agents? = null,
    val error: String = ""
)
