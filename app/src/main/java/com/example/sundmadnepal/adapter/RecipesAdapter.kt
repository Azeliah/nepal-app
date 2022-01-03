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
import com.example.sundmadnepal.data.Recipe

class RecipesAdapter(private val onClick: (Recipe) -> Unit) :
    ListAdapter<Recipe, RecipesAdapter.RecipeViewHolder>(RecipeDiffCallback) {

    class RecipeViewHolder(itemView: View, val onClick: (Recipe) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val recipeTextView: TextView = itemView.findViewById(R.id.recipe_title)
        private val recipeImageView: ImageView = itemView.findViewById(R.id.recipe_image)
        private var currentRecipe: Recipe? = null

        init {
            itemView.setOnClickListener {
                currentRecipe?.let { currentRecipe ->
                    onClick(currentRecipe)
                }
            }
        }

        fun bind(recipe: Recipe) {
            currentRecipe = recipe

            recipeTextView.text = recipe.title
            recipeImageView.setImageResource(recipe.image ?: R.drawable.dahl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item, parent, false)
        return RecipeViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = getItem(position)
        holder.bind(recipe)
    }
}

object RecipeDiffCallback : DiffUtil.ItemCallback<Recipe>() {
    override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
        return oldItem.id == newItem.id
    }
}
