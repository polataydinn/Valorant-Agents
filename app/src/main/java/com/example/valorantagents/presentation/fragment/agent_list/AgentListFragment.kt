package com.example.valorantagents.presentation.fragment.agent_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.example.valorantagents.databinding.FragmentAgentListBinding
import com.example.valorantagents.presentation.bindingadapter.BindingFragment
import com.example.valorantagents.presentation.fragment.agent_list.adapter.AgentsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AgentListFragment : BindingFragment<FragmentAgentListBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentAgentListBinding::inflate
    private val viewModel: AgentListViewModel by viewModels()
    private lateinit var adaper: AgentsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adaper = AgentsAdapter()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect { agentListState ->
                if (!agentListState.agents.isNullOrEmpty()) {
                    adaper.setList(agentListState.agents.shuffled())
                    binding.agentListRecyclerView.visibility = View.VISIBLE
                    binding.agentListRecyclerView.adapter = adaper
                }
                if (agentListState.error != "") {
                    binding.agentListErrorText.text = agentListState.error
                }
                binding.agentListProgressBar.isVisible = agentListState.isLoading ?: false
            }
        }
    }
}