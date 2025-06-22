package com.icon.be_web_ecommerce.Controller;

import com.icon.be_web_ecommerce.model.ProductRequest;
import com.icon.be_web_ecommerce.model.ProductResponse;
import org.apache.coyote.Response;
import org.springdoc.core.service.GenericResponseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private final GenericResponseService responseBuilder;

    public ProductController(GenericResponseService responseBuilder) {
        this.responseBuilder = responseBuilder;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long productId) {
        return ResponseEntity.ok(
                ProductResponse.builder()
                        .name("Product" + productId)
                        .price(BigDecimal.ONE)
                        .description("Deskripsi produk" + productId)
                        .build()
        );
    }


    @GetMapping("")
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(
                List.of(
                        ProductResponse.builder()
                                .name("Product 1")
                                .price(BigDecimal.ONE)
                                .description("product 1")
                                .build(),
                        ProductResponse.builder()
                                .name("Product 2")
                                .price(BigDecimal.ONE)
                                .description("product 2")
                                .build()
                )
        );
    }

    @PostMapping("")
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request) {
        return ResponseEntity.ok(
                ProductResponse.builder()
                        .name(request.getName())
                        .price(request.getPrice())
                        .description(request.getDescription())
                        .build()
        );
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long productId, @RequestBody ProductRequest request) {
       return ResponseEntity.ok(
               ProductResponse.builder()
                       .name(request.getName() + productId)
                       .price(request.getPrice())
                       .description(request.getDescription())
                       .build()
       );
    }
}
