package br.com.control.inventoryControl.mapper

import br.com.control.inventoryControl.dto.ProductForm
import br.com.control.inventoryControl.model.Product
import org.springframework.stereotype.Component

@Component
class ProductFormMapper : Mapper<ProductForm, Product>{

    override fun map(p: ProductForm): Product {
        return Product(
            name = p.name,
            amount = p.value,
            description = p.description,
            color = p.color,
            quantity = p.quantity
        )
    }
}
