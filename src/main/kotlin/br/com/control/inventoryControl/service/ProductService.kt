package br.com.control.inventoryControl.service

import br.com.control.inventoryControl.dto.ProductForm
import br.com.control.inventoryControl.dto.ProductView
import br.com.control.inventoryControl.dto.UpdateProductForm
import br.com.control.inventoryControl.mapper.ProductFormMapper
import br.com.control.inventoryControl.mapper.ProductViewMapper
import br.com.control.inventoryControl.model.Product
import br.com.control.inventoryControl.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ProductService(
    private val repository: ProductRepository,
    private val productViewMapper: ProductViewMapper,
    private val productFormMapper: ProductFormMapper
    ){

    fun list(): List<ProductView> {
        return repository.findAll().stream().map {
                p -> productViewMapper.map(p)
        }.collect(Collectors.toList())
    }

    fun searchById(id: Long): ProductView {
        val product = repository.findById(id).get()
        return productViewMapper.map(product)
    }

    fun registerProduct(form: ProductForm): ProductView{
        val product = productFormMapper.map(form)
        repository.save(product)
        return productViewMapper.map(product)
    }

    fun update(form: UpdateProductForm) : ProductView {
        val product = repository.findById(form.id).get()
        product.name = form.name
        product.code = form.code
        product.description = form.description
        product.color = form.color
        product.quantity = form.quantity

        return productViewMapper.map(product)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }

}