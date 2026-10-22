package com.example.valorantagents.presentation.fragment.agent_detail

import androidx.lifecycle.SavedStateHandle
import com.example.valorantagents.common.Constants
import com.example.valorantagents.fake.fakeAgent
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class AgentDetailViewModelTest {

    @Test
    fun `exposes agent from navigation arguments`() {
        val agent = fakeAgent("1", "Jett")

        val viewModel = AgentDetailViewModel(SavedStateHandle(mapOf(Constants.AGENT_ID to agent)))

        assertEquals(agent, viewModel.state.value.agents)
        assertEquals("", viewModel.state.value.error)
    }

    @Test
    fun `reports error when agent argument is missing`() {
        val viewModel = AgentDetailViewModel(SavedStateHandle())

        assertNull(viewModel.state.value.agents)
        assertTrue(viewModel.state.value.error.isNotEmpty())
    }

    @Test
    fun `reports error when agent has no abilities`() {
        val agent = fakeAgent("1", "Jett", abilities = emptyList())

        val viewModel = AgentDetailViewModel(SavedStateHandle(mapOf(Constants.AGENT_ID to agent)))

        assertNull(viewModel.state.value.agents)
        assertTrue(viewModel.state.value.error.isNotEmpty())
    }
}
