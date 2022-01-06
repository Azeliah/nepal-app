package com.example.sundmadnepal.model

import androidx.annotation.DrawableRes

data class QuizQuestion(
    val question : String,
    @DrawableRes val imageResourceId: Int?,
    val answer : Boolean
)