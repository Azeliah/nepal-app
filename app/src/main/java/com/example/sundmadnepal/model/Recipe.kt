package com.example.sundmadnepal.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Recipe(
    @StringRes val recipeNameId: Int,
    @DrawableRes val imageResourceId: Int,
    val ingredientList: List<IngredientMeasure>,
    val procedure: List<ProcedureStep>
)
