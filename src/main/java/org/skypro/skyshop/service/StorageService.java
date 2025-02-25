package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StorageService {
    private final Map<UUID, Product> storageProduct;
    private final Map<UUID, Article> storageArticle;

    public StorageService(Map<UUID, Product> storageProduct, Map<UUID, Article> storageArticle) {
        this.storageProduct = storageProduct;
        this.storageArticle = storageArticle;

        testData();
        System.out.println(storageProduct.values());
    }

    public Map<UUID, Product> getStorageProduct(){
       return storageProduct;
    }
    public Map<UUID, Article> getStorageArticle(){
        return storageArticle;
    }



    private void testData(){
        Product products1 = new SimpleProduct("Стул", 10, UUID.randomUUID());
        Product products2 = new SimpleProduct("Стул", 10000, UUID.randomUUID());
        Product products3 = new FixPriceProduct("Кресло", UUID.randomUUID());
        Product products4 = new DiscountedProduct("Пуфик", 1000, 10,  UUID.randomUUID());
        Product products5 = new DiscountedProduct("Кровать", 35000, 50, UUID.randomUUID());

        storageProduct.put(products1.getId(), products1);
        storageProduct.put(products2.getId(), products2);
        storageProduct.put(products3.getId(), products3);
        storageProduct.put(products4.getId(), products4);
        storageProduct.put(products5.getId(), products5);

        Article article1 = new Article("1", "Привет", UUID.randomUUID());

        storageArticle.put(article1.getId(), article1);
    }

    public Map<UUID, Searchable> getSearchables() {
        Map<UUID, Searchable> searchables = new HashMap<>();
        int i = 0;
        for (Product product : storageProduct.values()) {
            searchables.put(product.getId(), product);
            i++;
        }
        for (Article article : storageArticle.values()) {
            searchables.put(article.getId(), article);
            i++;
        }
        return searchables;
    }
}
