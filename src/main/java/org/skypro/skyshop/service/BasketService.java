package org.skypro.skyshop.service;


import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Service
@SessionScope
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addProduct(UUID id)  {

        Optional<Product> productBasket = storageService.getProductById(id);
         if (productBasket.isEmpty()) throw new IllegalArgumentException("Продукт не найден!");
        this.productBasket.addProduct(id);
    }

    public UserBasket getUserBasket(){
        ArrayList<BasketItem> basketItems = new ArrayList<>();
        for (Map.Entry<UUID, Integer> entry : productBasket.getBasket().entrySet()) {
            UUID productId = entry.getKey();
            int count = entry.getValue();

            Product product = storageService.getProductById(productId)
                    .orElseThrow(IllegalArgumentException::new);

            basketItems.add(new BasketItem(product, count));
        }

        return new UserBasket(basketItems);
    }
}
