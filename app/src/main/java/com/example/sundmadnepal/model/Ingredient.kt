package com.example.sundmadnepal.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * For now, a data class to hold data on ingredients.
 */
data class Ingredient(
    /* The ID of the ingredient (preparing for database) */
    @StringRes val id: Int,
    /* The name of the ingredient */
    @StringRes val name: Int,
    /* Picture of the ingredient (no constraints yet) */
    @DrawableRes val imageResourceId: Int,
    /* Measure (optional?) */
    @StringRes val measure: Int?,
    /* Unit of measure, consider using enumeration later. */
    @StringRes val unit: Int,
    /* TODO: Consider audio filename format? ingredient_{ID}?
        https://codersguidebook.com/how-to-create-an-android-app/play-sounds-music-android-app */
)