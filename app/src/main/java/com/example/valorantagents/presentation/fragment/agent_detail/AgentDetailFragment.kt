package com.example.valorantagents.presentation.fragment.agent_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.valorantagents.R
import com.example.valorantagents.databinding.FragmentAgentDetailBinding
import com.example.valorantagents.presentation.bindingadapter.BindingFragment
import com.example.valorantagents.presentation.fragment.agent_detail.adapter.AbilitiesAdapter

class AgentDetailFragment : BindingFragment<FragmentAgentDetailBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentAgentDetailBinding::inflate

    private val viewModel: AgentDetailViewModel by viewModels()
    private lateinit var adapter: AbilitiesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = AbilitiesAdapter()
        val state = viewModel.state

        if (state.value.error == ""){
            val agent = state.value.agents
            agent?.let {
                binding.apply {
                    detailAgentBiographyText.text = it.description
                    detailAgentName.text = it.displayName
                    detailAgentRole.text = it.role

                    Glide.with(detailImageBustPortrait)
                        .load(it.bustPortrait)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(detailImageBustPortrait)

                    Glide.with(detailImageFullPortrait)
                        .load(it.fullPortrait)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(detailImageFullPortrait)

                    adapter.setList(it.abilities)
                    abilityRecyclerView.adapter = adapter
                }

            }
        }
    }
}