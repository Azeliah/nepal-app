package com.example.sundmadnepal.model

class Recipe {
    var name: String? = null
    var imageUrl: String? = null
    var stepList: List<Step>? = null
    var ingredientList: List<Ingredient>? = null


    constructor() // Empty constructor for Firebase serialization

    constructor(
        name: String?,
        imageUrl: String?,
        stepList: List<Step>?,
        ingredientList: List<Ingredient>?
    ) {
        this.name = name
        this.imageUrl = imageUrl
        this.stepList = stepList
        this.ingredientList = ingredientList
    }
}
