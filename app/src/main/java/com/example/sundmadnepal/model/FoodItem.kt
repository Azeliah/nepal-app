package com.example.sundmadnepal.model

class FoodItem {
    var id: String? = null
    var name: String? = null
    var imageUrl: String? = null

    constructor() // Empty constructor for Firebase serialization

    constructor(
        id: String,
        name: String,
        imageUrl: String
    ) {
        this.name = name
        this.imageUrl = imageUrl
    }
}
