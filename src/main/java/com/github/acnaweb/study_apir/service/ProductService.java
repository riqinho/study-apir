package com.github.acnaweb.study_apir.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.acnaweb.study_apir.dto.ProductRequestCreate;
import com.github.acnaweb.study_apir.dto.ProductRequestUpdate;
import com.github.acnaweb.study_apir.model.Product;

@Service //spring automaticamente instancia essa classe em memória
public class ProductService {
    
    private List<Product> products = new ArrayList<>();

    private Long sequence = 1L;
    private static final  BigDecimal VALOR_PADRAO = new BigDecimal(10);

    public Product createProduct(ProductRequestCreate dto) {
        Product product = new Product();
        product.setId(sequence++);
        product.setNome(dto.getNome());
        product.setValor(VALOR_PADRAO);
        products.add(product);
        return product;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                        .findFirst()
                        .map(p -> {
                            return p;
                        });
    }

    public List<Product> getProductAll() {
        return this.products;
    }

    public Optional<Product> updateProduct(Long id, ProductRequestUpdate dto) {

        //aqui estamos percorrendo os items da lista products. Mesma coisa que um for, só que vem high level
        return products.stream()
                .filter(p -> p.getId().equals(id))
                        .findFirst()
                        .map(p -> {
                            p.setValor(dto.getValor());
                            return p;
                        });
    }

    public boolean deleteProduct(Long id) {
        return products.removeIf(p -> p.getId().equals(id));
    }
}
