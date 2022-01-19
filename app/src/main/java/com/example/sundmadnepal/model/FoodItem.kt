package com.example.sundmadnepal.model

class FoodItem {
    var name: String? = null
    var imageUrl: String? = null

    constructor() // Empty constructor for Firebase serialization

    constructor(
        name: String?,
        imageUrl: String?
    ) {
        this.name = name
        this.imageUrl = imageUrl
    }
}
