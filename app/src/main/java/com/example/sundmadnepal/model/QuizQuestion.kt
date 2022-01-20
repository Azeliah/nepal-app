package com.example.sundmadnepal.model

class QuizQuestion {
    var question: String = ""
    var imageUrl: String? = null
    var answer: Boolean = false

    constructor() // Empty constructor for Firebase serialization

    constructor(
        question: String,
        imageUrl: String?,
        answer: Boolean
    ) {
        this.question = question
        this.imageUrl = imageUrl
        this.answer = answer
    }
}
