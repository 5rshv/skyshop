package org.skypro.skyshop.model.product;

import org.skypro.skyshop.model.search.SearchResult;

import java.util.UUID;

public class DiscountedProduct extends Product {
    private double priceProduct;
    private double salePercent;

    public DiscountedProduct(String nameProduct, double priceProduct, double salePercent, UUID id) {
        super(nameProduct, id);
        if (priceProduct<=0){
            throw new IllegalArgumentException("Цена должна быть больше 0 ");
        }
        this.priceProduct = priceProduct;
        if (salePercent<0 || salePercent >100){
            throw new IllegalArgumentException("Скидка на товар не может быть меньше 0 и больше 100 ");
        }
        this.salePercent = salePercent;
    }


    public double getSalePercent() {
        return salePercent;
    }

    @Override
    public double getPriceProduct() {
        return priceProduct - (priceProduct * (salePercent / 100));
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return nameProduct +
                " : " + getPriceProduct() +
                " (Скидка: " + (int) salePercent + "%)";
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
