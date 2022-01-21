package com.example.sundmadnepal.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class QuizQuestion(
    @StringRes val question : Int,
    @DrawableRes val imageResourceId: Int?,
    val answer : Boolean
)