package com.shop.secondHands.order.service;

import com.siot.IamportRestClient.exception.IamportResponseException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public interface OrderService {
    void verifyPurchase(Map<String, String> data, Authentication authentication) throws IamportResponseException, IOException;
}
