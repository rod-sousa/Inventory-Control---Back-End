package br.com.control.inventoryControl.dto

data class ProductView (
    val id: Long?,
    val name: String,
    val code: Long?,
    val description: String?,
    val color: String,
    val quantity: Long,
    val alertMin: Boolean = false
)