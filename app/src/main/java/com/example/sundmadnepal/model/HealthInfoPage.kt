package com.example.sundmadnepal.model

// TODO: Set up for database?

data class HealthInfoPage(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val content: List<HealthInfoElement>,
)
