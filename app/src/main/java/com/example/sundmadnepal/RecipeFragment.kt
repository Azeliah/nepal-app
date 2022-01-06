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

    private var recipeIdUsage : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        arguments?.let{
            recipeIdUsage = it.getInt("recipeId")
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
        //Log.d(TAG, "Id of the recipe")
        //Log.d(TAG, recipeIdUsage.toString())
        val recipeInUse = loadRecipes().elementAt(recipeIdUsage-1)
        val recipeImage = view.findViewById<ImageView>(R.id.recipe_image)
        recipeImage.setImageResource(recipeInUse.image ?: R.drawable.dahl)
        if(recipeIdUsage != 0){

            /*val layout = requireView().findViewById<LinearLayout>(R.id.linear)
            setUpLayout(requireContext(), layout, recipeInUse)*/

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
    }



    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun stepOnclick(step: Step) {
        Log.d(TAG, "Ingredient clicked: $step")
    }


    private fun ingredientOnclick(ingredient: Ingredient) {
        //TODO implement if needed (directions), maybe just use a pop up ?
        Log.d(TAG, "Ingredient clicked: $ingredient")
    }

    private fun setUpLayout(context: Context, layout: LinearLayout, recipe: Recipe){
        val incrementer = 0
        for(i in recipe.ingredientList!!){
            val textView : TextView = LayoutInflater.from(context).inflate(R.layout.text_view_layout, null) as TextView
            textView.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            textView.gravity = Gravity.LEFT
            textView.text = i.measurements

            val imageView = ImageView(context)
            imageView.layoutParams = LinearLayout.LayoutParams(800,800)
            imageView.x = 20F
            imageView.y = 20f
            val imgResId = i.image
            var resId = imgResId
            imageView.setImageResource(resId!!)

            layout.addView(textView)
            layout.addView(imageView)

            //Log.d(TAG, requireView().findViewById<TextView>(R.id.TEXT_ID).text.toString())
        }
    }
}
