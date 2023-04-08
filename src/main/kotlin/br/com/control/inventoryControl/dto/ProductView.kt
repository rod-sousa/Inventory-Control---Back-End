package br.com.control.inventoryControl.dto

import java.math.BigDecimal

data class ProductView (
    val id: Long?,
    val name: String,
    val value: Double,
    val description: String?,
    val color: String,
    val quantity: Long,
    val alertMin: Boolean = false
)