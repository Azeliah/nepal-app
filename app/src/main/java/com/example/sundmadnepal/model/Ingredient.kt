package com.example.sundmadnepal.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Ingredient(
    @DrawableRes
    val image: Int?,
    val measurements: String,
)
