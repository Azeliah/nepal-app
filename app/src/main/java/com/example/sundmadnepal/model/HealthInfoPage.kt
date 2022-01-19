package com.example.sundmadnepal.model

class HealthInfoPage {
    var id: Int? = null
    var title: String? = null
    var imageUrl: String? = null
    var content: List<HealthInfoElement>? = null

    constructor() // Empty constructor for Firebase serialization

    constructor(
        id: Int,
        title: String,
        imageUrl: String,
        content: List<HealthInfoElement>
    ) {
        this.id = id
        this.title = title
        this.imageUrl = imageUrl
        this.content = content
    }
}
