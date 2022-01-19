package com.example.sundmadnepal.model

class HealthInfoElement {
    var type: ElementType? = null
    var contentRef: Int? = null

    constructor() // Empty constructor for Firebase serialization

    constructor(
        type: ElementType,
        contentRef: Int
    ) {
        this.type = type
        this.contentRef = contentRef
    }
}

enum class ElementType {
    PARAGRAPH,
    IMAGE,
}
