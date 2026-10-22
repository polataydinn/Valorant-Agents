package com.example.valorantagents.presentation.fragment.agent_list

import com.example.valorantagents.domain.use_case.get_agents.GetAgentsUseCase
import com.example.valorantagents.fake.FakeValorantRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.io.IOException

@OptIn(ExperimentalCoroutinesApi::class)
class AgentListViewModelTest {

    private lateinit var repository: FakeValorantRepository

    @Before
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        repository = FakeValorantRepository()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loads agents on init`() {
        val viewModel = AgentListViewModel(GetAgentsUseCase(repository))

        val state = viewModel.state.value
        assertFalse(state.isLoading)
        assertEquals("", state.error)
        assertEquals(repository.agents.toSet(), state.agents.toSet())
    }

    @Test
    fun `shows error and recovers on retry`() {
        repository.error = IOException()
        val viewModel = AgentListViewModel(GetAgentsUseCase(repository))

        assertTrue(viewModel.state.value.error.isNotEmpty())
        assertTrue(viewModel.state.value.agents.isEmpty())

        repository.error = null
        viewModel.getAgents()

        assertEquals("", viewModel.state.value.error)
        assertEquals(repository.agents.size, viewModel.state.value.agents.size)
    }
}
