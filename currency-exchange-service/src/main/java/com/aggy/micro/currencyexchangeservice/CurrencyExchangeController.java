package com.aggy.micro.currencyexchangeservice;

import com.aggy.micro.currencyexchangeservice.dao.ExchangeValueRepository;
import com.sun.javaws.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) throws InvalidArgumentException {
        ExchangeValue exchangeValue = exchangeValueRepository.findByCurrencyFromAndCurrencyTo(from, to);
        exchangeValue.setPort(Integer.valueOf(environment.getProperty("server.port")));
        if(exchangeValue == null) {
            throw new InvalidArgumentException(new String[]{"Nieobslugiwane waluty", from, to});
        }

        return exchangeValue;
    }
}
