package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {

    private static final double PRICE = 1000;

    public FixPriceProduct(String nameProduct, UUID id) {
        super(nameProduct, id);
    }

    @Override
    public double getPriceProduct() {
        return PRICE;
    }

    @Override
    public String toString() {
        return nameProduct +
                " : Фиксированная цена " + getPriceProduct();
    }
}
