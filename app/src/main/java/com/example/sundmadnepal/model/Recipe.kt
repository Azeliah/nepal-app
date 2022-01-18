package com.example.sundmadnepal.model

class Recipe {
    var id: Int? = null
    var name: String? = null
    var imageUrl: String? = null
    var stepList: List<Step>? = null
    var ingredientList: List<Ingredient>? = null

    // TODO: Find out if this constructor is necessary. Code lab suggests that it is.
    constructor() // Empty constructor for Firebase serialization (Is this needed??)

    constructor(
        id: Int?,
        name: String?,
        imageUrl: String?,
        stepList: List<Step>?,
        ingredientList: List<Ingredient>?
    ) {
        this.id = id
        this.name = name
        this.imageUrl = imageUrl
        this.stepList = stepList
        this.ingredientList = ingredientList
    }
}
