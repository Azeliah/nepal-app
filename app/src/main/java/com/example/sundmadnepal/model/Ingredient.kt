package com.example.sundmadnepal.model

class Ingredient {
    var foodItem: FoodItem? = null
    var measurement: String? = null

    constructor() // Empty constructor for Firebase serialization

    constructor(
        foodItem: FoodItem?,
        measurement: String?
    ) {
        this.foodItem = foodItem
        this.measurement = measurement
    }
}
