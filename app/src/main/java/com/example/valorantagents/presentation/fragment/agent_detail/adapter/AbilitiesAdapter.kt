package com.example.valorantagents.presentation.fragment.agent_detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.valorantagents.databinding.CustomAbilityItemBinding
import com.example.valorantagents.domain.model.Ability

class AbilitiesAdapter : ListAdapter<Ability, AbilitiesViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilitiesViewHolder {
        val binding =
            CustomAbilityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AbilitiesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AbilitiesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private object DiffCallback : DiffUtil.ItemCallback<Ability>() {
        override fun areItemsTheSame(oldItem: Ability, newItem: Ability) =
            oldItem.displayName == newItem.displayName
        override fun areContentsTheSame(oldItem: Ability, newItem: Ability) = oldItem == newItem
    }
}
