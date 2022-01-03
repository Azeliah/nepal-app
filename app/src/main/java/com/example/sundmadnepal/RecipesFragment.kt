package com.example.sundmadnepal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sundmadnepal.adapter.RecipesAdapter
import com.example.sundmadnepal.model.Recipe
import com.example.sundmadnepal.data.loadRecipes

private const val TAG = "RecipesFragment"

class RecipesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recipesAdapter = RecipesAdapter { recipe -> recipeOnClick(recipe) }
        recipesAdapter.submitList(loadRecipes())

        val recipesListView = view.findViewById<RecyclerView>(R.id.recipes_list)
        recipesListView.adapter = recipesAdapter
        recipesListView.setHasFixedSize(true)
    }

    private fun recipeOnClick(recipe: Recipe) {
        // TODO: Implement navigating to the recipe activity/fragment
        Log.d(TAG, "Recipe card clicked: $recipe")
    }
}
