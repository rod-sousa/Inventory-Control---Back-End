package br.com.control.inventoryControl.mapper

import br.com.control.inventoryControl.dto.ProductView
import br.com.control.inventoryControl.model.Product
import org.springframework.stereotype.Component

@Component
class ProductViewMapper: Mapper<Product, ProductView> {

    override fun map(p: Product): ProductView {
        return ProductView(
            id = p.id,
            name = p.name,
            value = p.amount,
            description = p.description,
            color = p.color,
            quantity = p.quantity,
            alertMin = p.quantity.toInt() < 3
        )
    }
}