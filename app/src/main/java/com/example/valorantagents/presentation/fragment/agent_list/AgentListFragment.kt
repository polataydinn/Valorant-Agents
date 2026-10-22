package com.example.valorantagents.presentation.fragment.agent_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.valorantagents.databinding.FragmentAgentListBinding
import com.example.valorantagents.domain.model.Agents
import com.example.valorantagents.presentation.bindingadapter.BindingFragment
import com.example.valorantagents.presentation.fragment.agent_list.adapter.AgentsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AgentListFragment : BindingFragment<FragmentAgentListBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentAgentListBinding::inflate
    private val viewModel: AgentListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AgentsAdapter { agent -> navigateDetailFragment(agent) }
        binding.agentListRecyclerView.adapter = adapter
        binding.agentListRetryButton.setOnClickListener { viewModel.getAgents() }

        observeState(adapter)
    }

    private fun navigateDetailFragment(agent: Agents) {
        findNavController().navigate(
            AgentListFragmentDirections.actionAgentListFragmentToAgentDetailFragment(
                agent
            )
        )
    }

    private fun observeState(adapter: AgentsAdapter) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { agentListState ->
                    adapter.submitList(agentListState.agents)
                    binding.apply {
                        agentListRecyclerView.isVisible = agentListState.agents.isNotEmpty()
                        agentListProgressBar.isVisible = agentListState.isLoading
                        agentListErrorText.isVisible = agentListState.error.isNotEmpty()
                        agentListErrorText.text = agentListState.error
                        agentListRetryButton.isVisible = agentListState.error.isNotEmpty()
                    }
                }
            }
        }
    }
}
