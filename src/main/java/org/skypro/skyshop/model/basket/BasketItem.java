package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;

public final class BasketItem {
    private final Product product;
    private final double count;

    public BasketItem(Product product, int quantity) {
        this.product = product;
        this.count = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double getCount() {
        return count;
    }
}
