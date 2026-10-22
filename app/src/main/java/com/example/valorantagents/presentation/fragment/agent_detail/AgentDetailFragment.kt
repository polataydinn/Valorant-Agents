package com.example.valorantagents.presentation.fragment.agent_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.valorantagents.databinding.FragmentAgentDetailBinding
import com.example.valorantagents.presentation.bindingadapter.BindingFragment
import com.example.valorantagents.presentation.fragment.agent_detail.adapter.AbilitiesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentDetailFragment : BindingFragment<FragmentAgentDetailBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentAgentDetailBinding::inflate

    private val viewModel: AgentDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val state = viewModel.state.value

        if (state.error.isNotEmpty()) {
            Toast.makeText(requireContext(), state.error, Toast.LENGTH_SHORT).show()
            findNavController().navigateUp()
            return
        }

        state.agents?.let {
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

                abilityRecyclerView.adapter = AbilitiesAdapter().apply { submitList(it.abilities) }
            }
        }
    }
}
