package com.example.sundmadnepal.model

class Step {
    var id: Int? = null
    var imageUrl: String? = null
    var stepText: String? = null

    constructor() // Empty constructor for Firebase serialization

    constructor(
        id: Int?,
        imageUrl: String?,
        stepText: String?
    ) {
        this.id = id
        this.imageUrl = imageUrl
        this.stepText = stepText
    }
}
