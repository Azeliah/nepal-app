package com.example.sundmadnepal.model

class FoodItem {
    var id: String = ""
    var name: String = ""
    var imageUrl: String = ""

    constructor() // Empty constructor for Firebase serialization

    constructor(
        id: String,
        name: String,
        imageUrl: String
    ) {
        this.id = id
        this.name = name
        this.imageUrl = imageUrl
    }
}
