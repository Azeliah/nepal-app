package com.example.sundmadnepal

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sundmadnepal.adapter.IngredientAdapter
import com.example.sundmadnepal.adapter.StepAdapter
import com.example.sundmadnepal.data.loadRecipes
import com.example.sundmadnepal.model.Ingredient
import com.example.sundmadnepal.model.Recipe
import com.example.sundmadnepal.model.Step

private const val TAG = "RecipeFragment"

class RecipeFragment : Fragment() {

    private var recipeId : Int = 1 //This is set to 1, so that if something "goes wrong" it will still load the first recipe... for now


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        arguments?.let{
            recipeId = it.getInt("recipeId")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recipeInUse = loadRecipes().elementAt(recipeId-1)
        val recipeImage = view.findViewById<ImageView>(R.id.recipe_image)
        recipeImage.setImageResource(recipeInUse.image ?: R.drawable.dahl)

        //Ingredient Adapter
        val ingredientAdapter = IngredientAdapter {ingredient -> ingredientOnclick(ingredient) }
        ingredientAdapter.submitList(recipeInUse.ingredientList)

        val ingredientListView = view.findViewById<RecyclerView>(R.id.ingredient_list)
        ingredientListView.layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        ingredientListView.adapter = ingredientAdapter
        ingredientListView.setHasFixedSize(true)
        Log.d(TAG, "So far so good")

        //Step Adapter
        val stepAdapter = StepAdapter {step -> stepOnclick(step)}
        stepAdapter.submitList(recipeInUse.stepList)

        val stepListView = view.findViewById<RecyclerView>(R.id.step_list)
        stepListView.adapter = stepAdapter
        stepListView.setHasFixedSize(true)
    }

    private fun stepOnclick(step: Step) {
        Log.d(TAG, "Ingredient clicked: $step")
    }

    private fun ingredientOnclick(ingredient: Ingredient) {
        //TODO implement if needed (directions), maybe just use a pop up ?
        Log.d(TAG, "Ingredient clicked: $ingredient")
    }
}
