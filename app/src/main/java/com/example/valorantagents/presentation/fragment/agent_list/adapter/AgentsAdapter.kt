package com.example.valorantagents.presentation.fragment.agent_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.valorantagents.databinding.CustomAgentItemBinding
import com.example.valorantagents.domain.model.Agents

class AgentsAdapter: RecyclerView.Adapter<AgentsViewHolder>() {
    private var agentsList = emptyList<Agents>()
    var onItemClick: ((Agents) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentsViewHolder {
        val binding = CustomAgentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AgentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AgentsViewHolder, position: Int) {
        holder.bind(agentsList[position], onItemClick)
    }

    override fun getItemCount() = agentsList.size

    fun setList(agentsList: List<Agents>){
        this.agentsList = agentsList
    }
}