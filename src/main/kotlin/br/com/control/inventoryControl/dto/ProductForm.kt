package br.com.control.inventoryControl.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal


data class ProductForm (
    @field:NotEmpty @field:Size(min = 3, max = 100) val name : String,
    val value: Double,
    val description: String? = null,
    @field:NotEmpty val color: String,
    @field:NotNull val quantity: Long
)