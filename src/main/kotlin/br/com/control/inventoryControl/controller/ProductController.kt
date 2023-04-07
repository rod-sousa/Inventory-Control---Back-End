package br.com.control.inventoryControl.controller

import br.com.control.inventoryControl.dto.ProductForm
import br.com.control.inventoryControl.dto.ProductView
import br.com.control.inventoryControl.dto.UpdateProductForm
import br.com.control.inventoryControl.service.ProductService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("product")
class ProductController (private val service: ProductService){

    @GetMapping
    fun productList(): List<ProductView>{
        return service.list()
    }

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Long) : ProductView {
        return service.searchById(id)
    }

    @PostMapping
    fun registerProduct(@RequestBody @Valid form: ProductForm){
        service.registerProduct(form)
    }

    @PutMapping
    fun update(@RequestBody @Valid form: UpdateProductForm){
        service.update(form)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long){
        service.delete(id)
    }
}