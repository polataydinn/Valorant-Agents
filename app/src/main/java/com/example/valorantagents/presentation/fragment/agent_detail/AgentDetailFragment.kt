package com.example.valorantagents.presentation.fragment.agent_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.valorantagents.R
import com.example.valorantagents.databinding.FragmentAgentDetailBinding
import com.example.valorantagents.presentation.bindingadapter.BindingFragment

class AgentDetailFragment : BindingFragment<FragmentAgentDetailBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentAgentDetailBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}