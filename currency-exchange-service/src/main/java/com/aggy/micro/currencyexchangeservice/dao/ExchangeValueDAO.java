package com.aggy.micro.currencyexchangeservice.dao;

import com.aggy.micro.currencyexchangeservice.ExchangeValue;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class ExchangeValueDAO {

    private static Map<String, ExchangeValue> exchangeValues = new HashMap<>();


    public ExchangeValue findByCurrencies(String from, String to) {
        String key = getKey(from, to);
        return exchangeValues.get(key);
    }

    private String getKey(String from, String to) {
        return from.concat(to);
    }

}
