package com.example.sundmadnepal.model

class Ingredient {
    var id: Int = -1
    var foodItem: FoodItem? = null
    var measurement: String = ""

    constructor() // Empty constructor for Firebase serialization

    constructor(
        id: Int,
        foodItem: FoodItem,
        measurement: String
    ) {
        this.id = id
        this.foodItem = foodItem
        this.measurement = measurement
    }
}
