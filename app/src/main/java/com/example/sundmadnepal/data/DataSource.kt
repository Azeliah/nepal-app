package com.example.sundmadnepal.data

import android.util.Log
import com.example.sundmadnepal.model.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


object DataSource {

    var auth: FirebaseAuth = Firebase.auth
    private var db: DatabaseReference = Firebase.database.reference
    private lateinit var ds: DataSnapshot
    lateinit var recipes: List<Recipe>
    lateinit var questions: List<QuizQuestion>
    lateinit var healthInfo: List<HealthInfoPage>

    init {
        db.child("dummy_data").get().addOnSuccessListener {
            Log.i("firebase", "Got value $(it.value)")
            ds = it
        }.addOnFailureListener {
            Log.e("firebase", "Error getting data", it)
        }

        loadRecipes(ds)
        loadQuestions(ds)
        loadHealthInfo(ds)
    }

    private fun loadRecipes(ds: DataSnapshot) {
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

        val recipeList = mutableListOf<Recipe>()
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
            recipeList.add(
                i,
                Recipe(
                    recipeSnapshot.child("name").toString(),
                    recipeSnapshot.child("imageUrl").toString(),
                    steps,
                    ingredients
                )

            )
        }

        recipes = recipeList
    }


    private fun loadQuestions(ds: DataSnapshot) {
        val questionList = mutableListOf<QuizQuestion>()

        ds.child("quiz_question").children.forEachIndexed { i, questionSnapshot ->
            var imageUrl: String? = null
            if (questionSnapshot.child("imageUrl").exists()) {
                imageUrl = questionSnapshot.child("imageUrl").toString()
            }
            questionList.add(
                i,
                QuizQuestion(
                    questionSnapshot.child("question").toString(),
                    imageUrl,
                    questionSnapshot.child("answer").value as Boolean
                )
            )
        }

        questions = questionList
    }

    private fun loadHealthInfo(ds: DataSnapshot) {
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

        healthInfo = healthInfoPages
    }
}
