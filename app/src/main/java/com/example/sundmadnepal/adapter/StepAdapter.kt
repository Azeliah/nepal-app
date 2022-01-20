package com.example.sundmadnepal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sundmadnepal.R
import com.example.sundmadnepal.model.Step
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class StepAdapter(private val onClick: (Step) -> Unit) :
    ListAdapter<Step, StepAdapter.StepViewHolder>(StepDiffCallback) {

    class StepViewHolder(itemView: View, val onClick: (Step) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        private val stepTextView = itemView.findViewById<TextView>(R.id.step_text)
        private val stepImageView = itemView.findViewById<ImageView>(R.id.step_image)
        private var currentStep: Step? = null

        init {
            itemView.setOnClickListener {
                currentStep?.let { currentStep ->
                    onClick(currentStep)
                }
            }
        }

        fun bind(step: Step) {
            currentStep = step

            stepTextView.text = step.stepText

            //If image of step is null, then hide the imageview, so there is no empty space in the recyclerview
            if (step.imageUrl != null) {
                val storageReference = Firebase.storage.getReferenceFromUrl(step.imageUrl!!)
                Glide.with(itemView)
                    .load(storageReference)
                    .into(stepImageView)
            } else {
                stepImageView.isVisible = false
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StepViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.step_item, parent, false)
        return StepViewHolder(view, onClick)

    }

    override fun onBindViewHolder(holder: StepViewHolder, position: Int) {
        val step = getItem(position)
        holder.bind(step)
    }

}

object StepDiffCallback : DiffUtil.ItemCallback<Step>() {
    override fun areItemsTheSame(oldItem: Step, newItem: Step): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Step, newItem: Step): Boolean {
        return oldItem.id == newItem.id
    }
}