package com.example.valorantagents.presentation.fragment.agent_list.adapter

import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.valorantagents.R
import com.example.valorantagents.databinding.CustomAgentItemBinding
import com.example.valorantagents.domain.model.Agents


class AgentsViewHolder(private val binding: CustomAgentItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(agents: Agents, onItemClick: ((Agents) -> Unit)?) {

        Glide.with(binding.root)
            .load(agents.fullPortrait)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    resource?.let {
                        Palette.from(it.toBitmap())
                            .generate { palette ->
                                val rgbMuted = palette?.mutedSwatch?.rgb ?: 0
                                val rgbDark = palette?.darkMutedSwatch?.rgb ?: 0
                                binding.agentBackground.setColorFilter(rgbDark)
                                val gd = GradientDrawable(
                                    GradientDrawable.Orientation.BOTTOM_TOP,
                                    intArrayOf(
                                        ContextCompat.getColor(binding.agentBackground.context, R.color.bunker),
                                        rgbMuted
                                    )
                                )
                                gd.cornerRadius = 35f
                                binding.agentBackground.setBackgroundDrawable(gd)
                            }
                    }
                    return false
                }

            })
            .into(binding.agentPortrait)

        Glide.with(binding.root)
            .load(agents.background)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.agentBackground)

        Glide.with(binding.root)
            .load(agents.agentRoleIcon)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.agentIcon)

        binding.agentName.text = agents.displayName
        binding.agentRole.text = agents.role
    }

}
