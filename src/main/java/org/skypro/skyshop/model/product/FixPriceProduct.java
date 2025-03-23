package org.skypro.skyshop.model.product;

import org.skypro.skyshop.model.search.SearchResult;

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
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return nameProduct +
                " : Фиксированная цена " + getPriceProduct();
    }

    @Override
    public String getStringRepresentation() {
        return super.getStringRepresentation();
    }

    @Override
    public SearchResult toSearchResult() {
        return super.toSearchResult();
    }
}
