package br.com.control.inventoryControl.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String,
    var code: Long?,
    var description: String?,
    var color: String,
    var quantity: Long,
    val alertMin: Boolean = false
)
