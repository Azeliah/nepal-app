package com.example.sundmadnepal.data

import com.example.sundmadnepal.R
import com.example.sundmadnepal.model.Recipe

class Datasource {
    fun loadRecipes(): List<Recipe> {
        return listOf<Recipe>(
            Recipe(R.string.dahl, R.drawable.dahl, null, null),
            Recipe(R.string.momo, R.drawable.momo, null, null),
            Recipe(R.string.fried_chicken, R.drawable.fried_chicken, null, null),
            Recipe(R.string.newari, R.drawable.newarithali, null, null)
        )
    }
}