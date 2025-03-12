package org.skypro.skyshop.controller;

import org.skypro.skyshop.exception.ShopError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
public class ShopControllerAdvice {
@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ShopError> handleNoSuchProductException(IllegalArgumentException e){
    return ResponseEntity.badRequest().body(new ShopError("418","i am a teapot"));
}
}
