package com.example.valorantagents.presentation.fragment.agent_detail.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.valorantagents.data.remote.dto.Ability
import com.example.valorantagents.databinding.CustomAbilityItemBinding

class AbilitiesViewHolder(private val binding: CustomAbilityItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(ability: Ability) {
        binding.apply {
            abilityName.text = ability.displayName
            abilityDescription.text = ability.description

            Glide.with(root)
                .load(ability.displayIcon)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(abilityIcon)
        }
    }
}
