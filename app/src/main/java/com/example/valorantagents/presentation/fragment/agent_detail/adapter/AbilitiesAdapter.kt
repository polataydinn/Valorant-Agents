package com.example.valorantagents.presentation.fragment.agent_detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.valorantagents.data.remote.dto.Ability
import com.example.valorantagents.databinding.CustomAbilityItemBinding

class AbilitiesAdapter : RecyclerView.Adapter<AbilitiesViewHolder>() {
    private var abilities = emptyList<Ability>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilitiesViewHolder {
        val binding =
            CustomAbilityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AbilitiesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AbilitiesViewHolder, position: Int) {
        holder.bind(abilities[position])
    }

    override fun getItemCount() = abilities.size

    fun setList(abilities: List<Ability>) {
        this.abilities = abilities
    }
}