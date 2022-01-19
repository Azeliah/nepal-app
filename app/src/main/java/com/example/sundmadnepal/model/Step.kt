package com.example.sundmadnepal.model

class Step {
    var imageUrl: String? = null
    var stepText: String? = null

    constructor() // Empty constructor for Firebase serialization

    constructor(
        imageUrl: String?,
        stepText: String
    ) {
        this.imageUrl = imageUrl
        this.stepText = stepText
    }
}
