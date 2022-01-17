package com.example.sundmadnepal.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

// TODO: Set up for database?

data class HealthInfoPage(
    val id: Int,
    @StringRes
    val title: Int,
    @DrawableRes
    val image: Int,
    val content: List<HealthInfoElement>,
)
