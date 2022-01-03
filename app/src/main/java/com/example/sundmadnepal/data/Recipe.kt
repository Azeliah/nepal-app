package com.example.sundmadnepal.data

import androidx.annotation.DrawableRes

data class Recipe(
    val id: Int,
    val title: String,
    @DrawableRes
    val image: Int?

    // TODO: Add member variables for the actual recipe
)
