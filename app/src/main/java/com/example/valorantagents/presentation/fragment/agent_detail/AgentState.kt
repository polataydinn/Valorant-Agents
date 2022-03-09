package com.example.valorantagents.presentation.fragment.agent_detail

import com.example.valorantagents.domain.model.Agents

data class AgentState(
    val agents: Agents? = null,
    val error: String = "",
    val rgbMuted: Int = 0,
    val rgbDark: Int = 0
)
