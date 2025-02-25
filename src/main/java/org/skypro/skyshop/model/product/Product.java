package org.skypro.skyshop.model.product;

import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;


public abstract class Product implements Searchable {
    protected String nameProduct;
    private final UUID id;

    public Product(String nameProduct, UUID id) {
        this.id = id;
        if (nameProduct == null || nameProduct.isBlank()) {
           throw new IllegalArgumentException("Пустая строка");
        }
        this.nameProduct = nameProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public abstract double getPriceProduct();

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product product)) return false;
        return Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameProduct);
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getTypeContent() {
        return "PRODUCT";
    }

    @Override
    public String getSearchTerm() {
        return getNameProduct() + " " + getTypeContent();
    }

}
