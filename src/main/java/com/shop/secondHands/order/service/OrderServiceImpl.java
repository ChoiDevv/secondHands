package com.shop.secondHands.order.service;

import com.shop.secondHands.order.entity.Order;
import com.shop.secondHands.order.repository.OrderRepository;
import com.shop.secondHands.user.entity.Users;
import com.shop.secondHands.user.service.UserServiceImpl;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    private final IamportClient iamportClient;

    private final UserServiceImpl userService;

    private final OrderRepository orderRepository;


    public OrderServiceImpl(UserServiceImpl userService, OrderRepository orderRepository, @Value("${portone.api_key}") String apiKey, @Value("${portone.api_secret}") String apiSecret) {
        this.userService = userService;
        this.orderRepository = orderRepository;
        this.iamportClient = new IamportClient(apiKey, apiSecret);
    }

    @Override
    public void verifyPurchase(Map<String, String> data, Authentication authentication) throws IamportResponseException, IOException {
        String impUid = data.get("imp_uid");
        String merchantUid = data.get("merchant_uid");
        int amount = Integer.parseInt(data.get("amount"));

        IamportResponse<Payment> portOneInquiry = portOneInquiry(impUid);
        verifyPayment(portOneInquiry, amount);
        saveOrder(merchantUid, amount, authentication);
    }

    private void saveOrder(String merchantUid, int amount, Authentication authentication) {
        Users currentUser = findByUserId(authentication);
        orderRepository.save(Order.toEntity(currentUser, merchantUid, amount));
    }

    /**
     * impUid로 결제 내역 조회(포트원 서버 내 결제 내역)
     * @param impUid
     * @return
     * @throws IamportResponseException
     * @throws IOException
     */
    public IamportResponse<Payment> portOneInquiry(String impUid) throws IamportResponseException, IOException {
        return iamportClient.paymentByImpUid(impUid);
    }


    private void verifyPayment(IamportResponse<Payment> portOneInquiry, int amount) throws IamportResponseException, IOException {
        if (portOneInquiry.getResponse().getAmount().intValue() != amount) {
            throw new IOException("가격에 변동이 발생했습니다.");
        }
    }

    public Users findByUserId(Authentication authentication) {
        return userService.findByUserId(userService.userId(authentication));
    }
}
