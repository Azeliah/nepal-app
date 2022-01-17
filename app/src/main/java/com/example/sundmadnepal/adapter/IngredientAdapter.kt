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
import com.example.sundmadnepal.model.Ingredient

class IngredientAdapter(private val onClick: (Ingredient) -> Unit) :
    ListAdapter<Ingredient, IngredientAdapter.IngredientViewHolder>(IngredientDiffCallback) {

    class IngredientViewHolder(itemView: View, val onClick: (Ingredient) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        private val ingredientTextView = itemView.findViewById<TextView>(R.id.measurement)
        private val ingredientImageView = itemView.findViewById<ImageView>(R.id.ingredient)
        private var currentIngredient: Ingredient? = null

        init {
            itemView.setOnClickListener {
                currentIngredient?.let { currentIngredient ->
                    onClick(currentIngredient)
                }
            }
        }

        fun bind(ingredient: Ingredient) {
            currentIngredient = ingredient

            ingredientTextView.text = ingredient.measurements
            ingredientImageView.setImageResource(
                ingredient.image ?: R.drawable.pudding_ingredienses
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.ingredient_item, parent, false)
        return IngredientViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        val ingredient = getItem(position)
        holder.bind(ingredient)
    }
}

object IngredientDiffCallback : DiffUtil.ItemCallback<Ingredient>() {
    override fun areItemsTheSame(oldItem: Ingredient, newItem: Ingredient): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Ingredient, newItem: Ingredient): Boolean {
        return oldItem.id == newItem.id
    }
}