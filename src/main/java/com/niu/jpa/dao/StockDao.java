package com.niu.jpa.dao;

import com.niu.jpa.entity.StockDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockDao extends JpaRepository<StockDO, String> {
    StockDO findBySymbol(String symbol);
}
