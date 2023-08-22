package com.shop.secondHands.user.exception;

public class BasketNotFoundException extends RuntimeException {
    public BasketNotFoundException(String message) {
        super(message);
    }
}
