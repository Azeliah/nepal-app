package com.example.sundmadnepal.data

import android.util.Log
import com.example.sundmadnepal.model.*
import com.google.firebase.database.DataSnapshot


class DataSource(dataSnapshot: DataSnapshot) {
    private val ds: DataSnapshot = dataSnapshot

// TODO: Redefine loadRecipes, loadQuestions, loadHealthInfo


    fun loadRecipes(): List<Recipe> {
        // TODO: Add security to ward off null elements.
        val foodItems = mutableListOf<FoodItem>()
        ds.child("foodItem").children.forEachIndexed { i, foodItemSnapshot ->
            foodItems.add(
                i,
                FoodItem(
                    foodItemSnapshot.key.toString(),
                    foodItemSnapshot.child("name").toString(),
                    foodItemSnapshot.child("imageUrl").toString()
                )
            )
        }

        val recipes = mutableListOf<Recipe>()
        ds.child("recipe").children.forEachIndexed { i, recipeSnapshot ->
            val ingredients = mutableListOf<Ingredient>()

            recipeSnapshot.child("ingredient").children.forEachIndexed { j, ingredientSnapshot ->
                val foodItemKey = ingredientSnapshot.child("foodItem").toString()
                var targetFoodItem: FoodItem? = null
                for (ele in foodItems) {
                    if (ele.id.equals(foodItemKey)) {
                        targetFoodItem = ele
                        break
                    }
                }
                if (targetFoodItem == null)
                    Log.e("DataImport", "Couldn't find food item with key $foodItemKey")


                ingredients.add(
                    j,
                    Ingredient(
                        targetFoodItem,
                        ingredientSnapshot.child("measurement").toString()
                    )
                )
            }

            val steps = mutableListOf<Step>()

            recipeSnapshot.child("step").children.forEachIndexed { j, stepSnapshot ->
                var imageUrl: String? = null
                if (stepSnapshot.child("imageUrl").exists()) {
                    imageUrl = stepSnapshot.child("imageUrl").toString()
                }
                steps.add(
                    j,
                    Step(
                        imageUrl,
                        stepSnapshot.child("stepText").toString()
                    )
                )
            }
            recipes.add(
                i,
                Recipe(
                    recipeSnapshot.child("name").toString(),
                    recipeSnapshot.child("imageUrl").toString(),
                    steps,
                    ingredients
                )

            )
        }
        return recipes
    }


    fun loadQuestions(): List<QuizQuestion> {
        val questions = mutableListOf<QuizQuestion>()

        ds.child("quiz_question").children.forEachIndexed { i, questionSnapshot ->
            var imageUrl: String? = null
            if (questionSnapshot.child("imageUrl").exists()) {
                imageUrl = questionSnapshot.child("imageUrl").toString()
            }
            questions.add(
                i,
                QuizQuestion(
                    questionSnapshot.child("question").toString(),
                    imageUrl,
                    questionSnapshot.child("answer").value as Boolean
                )
            )
        }
        return questions
    }

    fun loadHealthInfo(): List<HealthInfoPage> {
        val healthInfoPages = mutableListOf<HealthInfoPage>()

        ds.child("health_info_page").children.forEachIndexed { i, pageData ->
            val healthInfoElements = mutableListOf<HealthInfoElement>()
            pageData.child("content").children.forEachIndexed { j, contentData ->
                val elementType = if (contentData.child("type").value as Int == 0) {
                    ElementType.PARAGRAPH
                } else {
                    ElementType.IMAGE
                }
                healthInfoElements.add(
                    j,
                    HealthInfoElement(
                        elementType,
                        contentData.child("contentRef").toString()
                    )
                )
            }
            healthInfoPages.add(
                i,
                HealthInfoPage(
                    i,
                    pageData.child("title").toString(),
                    pageData.child("imageUrl").toString(),
                    healthInfoElements
                )
            )
        }
        return healthInfoPages
    }
}
