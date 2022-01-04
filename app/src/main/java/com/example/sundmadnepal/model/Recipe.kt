package com.example.sundmadnepal.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recipe(
    val id: Int,
    @StringRes
    val name: Int,
    @DrawableRes
    val image: Int?,
    val stepList : List<String>? = null,
    val ingredientList : List<Ingredient>? = null,
)
