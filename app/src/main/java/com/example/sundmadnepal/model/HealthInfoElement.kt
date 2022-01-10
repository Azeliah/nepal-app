package com.example.sundmadnepal.model

data class HealthInfoElement(
    val type: ElementType,
    val contentRef: Int,
)

enum class ElementType {
    PARAGRAPH,
    IMAGE,
}
