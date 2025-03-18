package org.skypro.skyshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (code = HttpStatus.BAD_REQUEST)
public class NoSuchProductException extends RuntimeException {
    public NoSuchProductException(){
        super("Ничего нет");
    }
}