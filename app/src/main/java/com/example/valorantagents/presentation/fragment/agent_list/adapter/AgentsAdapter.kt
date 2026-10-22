package com.example.valorantagents.presentation.fragment.agent_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.valorantagents.databinding.CustomAgentItemBinding
import com.example.valorantagents.domain.model.Agents

class AgentsAdapter(
    private val onItemClick: (Agents) -> Unit
) : ListAdapter<Agents, AgentsViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentsViewHolder {
        val binding = CustomAgentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AgentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AgentsViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClick)
    }

    private object DiffCallback : DiffUtil.ItemCallback<Agents>() {
        override fun areItemsTheSame(oldItem: Agents, newItem: Agents) = oldItem.uuid == newItem.uuid
        override fun areContentsTheSame(oldItem: Agents, newItem: Agents) = oldItem == newItem
    }
}
