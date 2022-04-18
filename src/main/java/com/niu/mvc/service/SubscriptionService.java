package com.niu.mvc.service;

import com.niu.mvc.model.StockSubscription;

import java.util.List;

public interface SubscriptionService {
    List<StockSubscription> findByEmail(String email);

    void addSubscription(String email, String symbol);
}
