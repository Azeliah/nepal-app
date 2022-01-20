package com.example.sundmadnepal

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.sundmadnepal.adapter.RecipesAdapter
import com.example.sundmadnepal.data.DataSource
import com.example.sundmadnepal.data.loadRecipes
import com.example.sundmadnepal.model.Recipe

private const val TAG = "RecipesFragment"

class RecipesFragment : Fragment() {

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
        recipesAdapter.submitList(DataSource.recipes)

        val recipesListView = view.findViewById<RecyclerView>(R.id.recipes_list)
        recipesListView.adapter = recipesAdapter
        recipesListView.setHasFixedSize(true)
    }

    private fun recipeOnClick(recipe: Recipe) {
        val action =
            RecipesFragmentDirections.actionRecipesFragmentToRecipeFragment(recipeId = recipe.id!!)
        findNavController().navigate(action)
        Log.d(TAG, "Recipe card clicked: $recipe")
    }
}
