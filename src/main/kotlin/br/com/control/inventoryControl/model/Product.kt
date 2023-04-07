package br.com.control.inventoryControl.model

data class Product(
    var id: Long? = null,
    val name: String,
    val code: Long?,
    val description: String?,
    val color: String,
    val quantity: Long,
    val alertMin: Boolean = false
)
