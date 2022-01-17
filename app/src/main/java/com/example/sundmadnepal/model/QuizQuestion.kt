package com.example.sundmadnepal.model

import androidx.annotation.DrawableRes


// TODO: Set up for database import (Finish recipe part first)
data class QuizQuestion(
    val question: String,
    @DrawableRes val imageResourceId: Int?,
    val answer: Boolean
)