package com.example.sundmadnepal.model

class Ingredient {
    var id: Int? = null
    var foodItem: FoodItem? = null
    var measurement: String? = null

    constructor() // Empty constructor for Firebase serialization

    constructor(
        id: Int?,
        foodItem: FoodItem?,
        measurement: String?
    ) {
        this.id = id
        this.foodItem = foodItem
        this.measurement = measurement
    }
}
