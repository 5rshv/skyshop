package org.skypro.skyshop.exception;

public class NoSuchProductException extends java.lang.RuntimeException {
    public NoSuchProductException(){
        super("Ничего нет");
    }
}