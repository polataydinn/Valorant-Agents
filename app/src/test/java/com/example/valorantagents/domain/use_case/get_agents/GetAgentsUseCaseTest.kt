package com.example.valorantagents.domain.use_case.get_agents

import com.example.valorantagents.common.Resource
import com.example.valorantagents.fake.FakeValorantRepository
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class GetAgentsUseCaseTest {

    private lateinit var repository: FakeValorantRepository
    private lateinit var getAgents: GetAgentsUseCase

    @Before
    fun setUp() {
        repository = FakeValorantRepository()
        getAgents = GetAgentsUseCase(repository)
    }

    @Test
    fun `emits loading then success with agents`() = runTest {
        val results = getAgents().toList()

        assertEquals(2, results.size)
        assertTrue(results[0] is Resource.Loading)
        assertTrue(results[1] is Resource.Success)
        assertEquals(repository.agents, results[1].data)
    }

    @Test
    fun `emits connection error on IOException`() = runTest {
        repository.error = IOException()

        val result = getAgents().toList().last()

        assertTrue(result is Resource.Error)
        assertEquals("Couldn't reach server. Check your internet connection.", result.message)
    }

    @Test
    fun `emits error on HttpException`() = runTest {
        repository.error = HttpException(Response.error<Any>(500, "".toResponseBody(null)))

        val result = getAgents().toList().last()

        assertTrue(result is Resource.Error)
        assertTrue(result.message.orEmpty().isNotEmpty())
    }
}
