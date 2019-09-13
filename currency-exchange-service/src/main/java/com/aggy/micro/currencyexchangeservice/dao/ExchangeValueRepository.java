package com.aggy.micro.currencyexchangeservice.dao;

import com.aggy.micro.currencyexchangeservice.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    ExchangeValue findByCurrencyFromAndCurrencyTo(String currencyFrom, String currencyTo);
}
