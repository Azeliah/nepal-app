package com.example.sundmadnepal.model

import androidx.annotation.DrawableRes

data class Step (
    val id: Int,
    @DrawableRes
    val image: Int?,
    val stepText: String,
)