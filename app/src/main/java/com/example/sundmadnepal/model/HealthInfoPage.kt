package com.example.sundmadnepal.model

class HealthInfoPage {
    var id: Int = -1
    var title: String = ""
    var imageUrl: String = ""
    var content: List<HealthInfoElement> = emptyList()

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
