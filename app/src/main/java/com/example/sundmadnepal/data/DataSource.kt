package com.example.sundmadnepal.data

import com.example.sundmadnepal.R
import com.example.sundmadnepal.model.QuizQuestion
import com.example.sundmadnepal.model.Recipe

fun loadRecipes(): List<Recipe> {

    // This is just dummy data, until we can implement a proper repository for recipe data
    return listOf(
        Recipe(
            id = 1,
            name = R.string.dahl,
            image = R.drawable.dahl
        ),
        Recipe(
            id = 2,
            name = R.string.momo,
            image = R.drawable.momo
        ),
        Recipe(
            id = 3,
            name = R.string.newari,
            image = R.drawable.newarithali
        ),
        Recipe(
            id = 4,
            name = R.string.fried_chicken,
            image = R.drawable.fried_chicken
        )
    )
}

// Dummy data for quiz questions
class DataSource {
    fun loadQuestions(): List<QuizQuestion> {
        return listOf(
            QuizQuestion("Is this healthy?", R.drawable.fried_chicken, false),
            QuizQuestion("Is this healthy?", R.drawable.potatoes, true),
            QuizQuestion("Is it healthy for your child to eat chips", null, false)
        )
    }
}
