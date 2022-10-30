package dev.hashnode.tusharpingale.models

import kotlinx.serialization.Serializable

@Serializable
data class Recipe(
    val id: Long = 0,
    val name: String,
    val description: String,
    val coverUrl: String
)
