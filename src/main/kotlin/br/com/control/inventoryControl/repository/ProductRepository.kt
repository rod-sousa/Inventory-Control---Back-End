package br.com.control.inventoryControl.repository

import br.com.control.inventoryControl.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long> {
}