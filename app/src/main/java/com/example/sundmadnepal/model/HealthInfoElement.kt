package com.example.sundmadnepal.model

data class HealthInfoElement(
    val type: ElementType,
    val content: Any,
)

enum class ElementType {
    PARAGRAPH,
    IMAGE,
}
