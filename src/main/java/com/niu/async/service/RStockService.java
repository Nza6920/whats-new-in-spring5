package com.niu.async.service;


import com.niu.mvc.model.Stock;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public interface RStockService {
    Future<List<Stock>> getAllStocksAsync();
    //understand why we use CompletableFuture here.
    CompletableFuture<List<Stock>> getAllStocks();
}
