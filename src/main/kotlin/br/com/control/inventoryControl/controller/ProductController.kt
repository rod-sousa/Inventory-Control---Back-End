package br.com.control.inventoryControl.controller

import br.com.control.inventoryControl.dto.ProductForm
import br.com.control.inventoryControl.dto.ProductView
import br.com.control.inventoryControl.dto.UpdateProductForm
import br.com.control.inventoryControl.service.ProductService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

import java.util.*

@CrossOrigin(origins = arrayOf("http://localhost:4200"))
@RestController
@RequestMapping("product")
class ProductController (private val service: ProductService){

    @GetMapping
    fun productList(
        @RequestParam(required = false) nameProduct: String?,
        @PageableDefault(sort = ["id"], direction = Sort.Direction.DESC) pagination: Pageable
        ): Page<ProductView> {
        return service.list(nameProduct, pagination)
    }

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Long) : ProductView {
        return service.searchById(id)
    }

    @PostMapping
    @Transactional
    fun registerProduct(
        @RequestBody @Valid form: ProductForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ProductView>{
        val productView = service.registerProduct(form)
        val uri = uriBuilder.path("/product/${productView.id}").build().toUri()
        return ResponseEntity.created(uri).body(productView)
    }

    @PutMapping
    @Transactional
    fun update(@RequestBody @Valid form: UpdateProductForm) : ResponseEntity<ProductView>{
        val productView = service.update(form)
        return ResponseEntity.ok(productView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun delete(@PathVariable id: Long){
        service.delete(id)
    }
}