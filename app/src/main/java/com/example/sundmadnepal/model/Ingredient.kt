package com.example.sundmadnepal.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Ingredient(
    val id: Int,
    @DrawableRes
    val image: Int?,
    val measurements: String,
)
