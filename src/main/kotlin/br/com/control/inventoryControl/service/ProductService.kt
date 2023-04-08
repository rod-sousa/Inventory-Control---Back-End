package br.com.control.inventoryControl.service

import br.com.control.inventoryControl.dto.ProductForm
import br.com.control.inventoryControl.dto.ProductView
import br.com.control.inventoryControl.dto.UpdateProductForm
import br.com.control.inventoryControl.mapper.ProductFormMapper
import br.com.control.inventoryControl.mapper.ProductViewMapper
import br.com.control.inventoryControl.model.Product
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ProductService(
    private var productList: List<Product> = ArrayList(),
    private val productViewMapper: ProductViewMapper,
    private val productFormMapper: ProductFormMapper
    ){

    fun list(): List<ProductView> {
        return productList.stream().map {
                p -> productViewMapper.map(p)
        }.collect(Collectors.toList())
    }

    fun searchById(id: Long): ProductView {
        val product = productList.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        return productViewMapper.map(product)
    }

    fun registerProduct(form: ProductForm): ProductView{
        val product = productFormMapper.map(form)
        product.id = productList.size.toLong() + 1
        productList = productList.plus(product)
        return productViewMapper.map(product)
    }

    fun update(form: UpdateProductForm) : ProductView {
        val product = productList.stream().filter { p ->
            p.id == form.id
        }.findFirst().get()
        val productUpdate = Product(
            id = form.id,
            name = form.name,
            code = form.code,
            description = form.description,
            color = form.color,
            quantity = form.quantity,
            alertMin = product.alertMin
        )
        productList = productList.minus(product).plus(productUpdate)
        return productViewMapper.map(productUpdate)
    }

    fun delete(id: Long) {
        val product = productList.stream().filter { p ->
            p.id == id
        }.findFirst().get()
        productList = productList.minus(product)
    }

}