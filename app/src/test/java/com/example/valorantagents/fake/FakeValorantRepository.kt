package com.example.valorantagents.fake

import com.example.valorantagents.domain.model.Ability
import com.example.valorantagents.domain.model.Agents
import com.example.valorantagents.domain.repository.ValorantRepository

class FakeValorantRepository : ValorantRepository {
    var agents: List<Agents> = listOf(fakeAgent("1", "Jett"), fakeAgent("2", "Raze"))
    var error: Throwable? = null

    override suspend fun getPlayableAgents(): List<Agents> {
        error?.let { throw it }
        return agents
    }
}

fun fakeAgent(uuid: String, name: String, abilities: List<Ability> = listOf(fakeAbility())) = Agents(
    uuid = uuid,
    displayName = name,
    role = "Duelist",
    fullPortrait = "https://example.com/$uuid/full.png",
    background = "https://example.com/$uuid/background.png",
    agentRoleIcon = "https://example.com/duelist.png",
    abilities = abilities,
    bustPortrait = "https://example.com/$uuid/bust.png",
    description = "$name description"
)

fun fakeAbility() = Ability(
    displayName = "Updraft",
    description = "Propel upwards.",
    displayIcon = null
)
