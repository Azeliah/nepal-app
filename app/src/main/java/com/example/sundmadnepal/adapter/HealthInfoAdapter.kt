package com.example.sundmadnepal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sundmadnepal.R
import com.example.sundmadnepal.model.HealthInfoPage

class HealthInfoAdapter(private val onClick: (HealthInfoPage) -> Unit) :
    ListAdapter<HealthInfoPage, HealthInfoAdapter.HealthInfoViewHolder>(HealthInfoDiffCallback) {

    class HealthInfoViewHolder(itemView: View, val onClick: (HealthInfoPage) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val healthInfoTextView: TextView = itemView.findViewById(R.id.health_info_title)
        private val healthInfoImageView: ImageView = itemView.findViewById(R.id.health_info_image)
        private var currentHealthInfoPage: HealthInfoPage? = null

        init {
            itemView.setOnClickListener {
                currentHealthInfoPage?.let { currentHealthInfoPage ->
                    onClick(currentHealthInfoPage)
                }
            }
        }

        fun bind(healthInfoPage: HealthInfoPage) {
            currentHealthInfoPage = healthInfoPage

            healthInfoTextView.setText(healthInfoPage.title)
            // TODO: Change image resource
            healthInfoImageView.setImageResource(healthInfoPage.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthInfoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.health_info_item, parent, false)
        return HealthInfoViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: HealthInfoViewHolder, position: Int) {
        val healthInfoPage = getItem(position)
        holder.bind(healthInfoPage)
    }
}

object HealthInfoDiffCallback : DiffUtil.ItemCallback<HealthInfoPage>() {
    override fun areItemsTheSame(oldItem: HealthInfoPage, newItem: HealthInfoPage): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HealthInfoPage, newItem: HealthInfoPage): Boolean {
        return oldItem.id == newItem.id
    }
}
