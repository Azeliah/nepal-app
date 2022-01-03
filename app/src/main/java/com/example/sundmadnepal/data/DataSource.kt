package com.example.sundmadnepal.data

import com.example.sundmadnepal.R
import com.example.sundmadnepal.model.Recipe

class Datasource {
    fun loadRecipes(): List<Recipe>{
        return listOf<Recipe>(
            Recipe(R.string.dahl, R.drawable.dahl),
            Recipe(R.string.momo, R.drawable.momo),
            Recipe(R.string.fried_chicken, R.drawable.fried_chicken),
            Recipe(R.string.newari, R.drawable.newarithali)
        )
    }
}