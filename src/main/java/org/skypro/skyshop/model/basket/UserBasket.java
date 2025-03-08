package org.skypro.skyshop.model.basket;


import java.util.ArrayList;

public class UserBasket {
private final ArrayList<BasketItem> basket;
private final double total;

    public UserBasket(ArrayList<BasketItem> basket) {
        this.basket = basket;
        this.total = basket.stream()
                .mapToDouble(item -> item.getProduct().getPriceProduct() * item.getQuantity())
                .sum();
    }

    public double getTotal() {
        return total;
    }

    public ArrayList<BasketItem> getBasket() {
        return basket;
    }
}
