package com.example.sundmadnepal.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recipe(
    val id: Int,
    @StringRes
    val name: Int,
    @DrawableRes
    val image: Int?

    // TODO: Add member variables for the actual recipe
)
