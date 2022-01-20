package com.example.sundmadnepal.model

class Recipe {
    var id: Int = -1
    var name: String = ""
    var imageUrl: String = ""
    var stepList: List<Step> = emptyList()
    var ingredientList: List<Ingredient> = emptyList()


    constructor() // Empty constructor for Firebase serialization

    constructor(
        id: Int,
        name: String,
        imageUrl: String,
        stepList: List<Step>,
        ingredientList: List<Ingredient>
    ) {
        this.id = id
        this.name = name
        this.imageUrl = imageUrl
        this.stepList = stepList
        this.ingredientList = ingredientList
    }
}
