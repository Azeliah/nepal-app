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
import com.example.sundmadnepal.R
import com.example.sundmadnepal.model.Step

class StepAdapter (private val onClick: (Step) -> Unit) :
    ListAdapter<Step, StepAdapter.StepViewHolder>(StepDiffCallback) {

    class StepViewHolder (itemView: View, val onClick: (Step) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        private val stepTextView = itemView.findViewById<TextView>(R.id.step_text)
        private val stepImageView = itemView.findViewById<ImageView>(R.id.step_image)
        private var currentStep: Step? = null

        init {
            //For now its only by click on text that it will be read out loud
            //TODO: Implement this with an image or the likes of it ?
            stepTextView.setOnClickListener {
                currentStep?.let { currentStep ->
                    onClick(currentStep)
                }
            }
        }

        fun bind(step: Step){
            currentStep = step

            stepTextView.text = step.stepText

            //If image of step is null, then hide the imageview, so there is no empty space in the recyclerview
            if(step.image != null) {
                stepImageView.setImageResource(step.image)
            } else{
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