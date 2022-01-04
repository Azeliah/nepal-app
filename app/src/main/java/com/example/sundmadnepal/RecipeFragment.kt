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
import com.example.sundmadnepal.data.loadRecipes
import com.example.sundmadnepal.model.Recipe

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
        Log.d(TAG, "Id of the recipe")
        Log.d(TAG, recipeIdUsage.toString())
        if(recipeIdUsage != 0){
            val recipeInUse = loadRecipes().elementAt(recipeIdUsage-1)
            val layout = requireView().findViewById<LinearLayout>(R.id.linear)
            setUpLayout(requireContext(), layout, recipeInUse)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun setUpLayout(context: Context, layout: LinearLayout, recipe: Recipe){
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
        }
    }
}
