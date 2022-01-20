package com.example.sundmadnepal.model

class HealthInfoElement {
    var type: ElementType = ElementType.PARAGRAPH
    var contentRef: String = ""

    constructor() // Empty constructor for Firebase serialization

    constructor(
        type: ElementType,
        contentRef: String
    ) {
        this.type = type
        this.contentRef = contentRef
    }
}

enum class ElementType {
    PARAGRAPH,
    IMAGE,
}
