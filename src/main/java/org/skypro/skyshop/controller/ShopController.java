package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.skypro.skyshop.service.StorageService;


import java.util.Collection;

@RestController
public class ShopController {
    // Инъекцирование зависимости
    private final StorageService storageService;
    private final SearchService searchService;

    public ShopController(StorageService storageService, SearchService searchService) {
        this.storageService = storageService;
        this.searchService = searchService;
    }

    @GetMapping("/products")
    public Collection<Product> getAllProducts() {
        return storageService.getStorageProduct().values();
    }

    @GetMapping("/product")
    public String PrintText(){
       return "dqdqw";
    }


    @GetMapping("/articles")
    public Collection<Article> getAllArticles(){
        return storageService.getStorageArticle().values();
    }
    @GetMapping("/search")
    public Collection<SearchResult>  search(@RequestParam("pattern") String pattern){
        return searchService.search(pattern).values();
    }
}
