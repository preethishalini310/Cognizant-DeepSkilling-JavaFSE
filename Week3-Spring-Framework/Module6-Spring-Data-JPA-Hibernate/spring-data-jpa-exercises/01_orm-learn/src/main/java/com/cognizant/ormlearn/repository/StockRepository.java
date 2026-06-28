package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Repository for Stock entity.
 * FILE 2 – Hands-on 2: Stock Query Methods
 */
@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    /**
     * Get all stock records for a given company code within a date range.
     * Usage: FB records for September 2019
     *   findByCodeAndDateBetween("FB", startDate, endDate)
     */
    List<Stock> findByCodeAndDateBetween(String code, Date startDate, Date endDate);

    /**
     * Get all records for a code where close price is greater than a threshold.
     * Usage: GOOGL records where close > 1250
     */
    List<Stock> findByCodeAndCloseGreaterThan(String code, double threshold);

    /**
     * Top 3 records with highest volume across all stocks.
     */
    List<Stock> findTop3ByOrderByVolumeDesc();

    /**
     * Bottom 3 (lowest close price) records for a given code.
     * Usage: lowest Netflix stock prices
     */
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
