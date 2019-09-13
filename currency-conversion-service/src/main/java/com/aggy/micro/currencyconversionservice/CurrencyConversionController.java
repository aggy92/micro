package com.aggy.micro.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        Map<String, String> params = new HashMap<>();
        params.put("from",from);
        params.put("to", to);
        ResponseEntity<CurrencyConversionBean> responseEntity =  new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}/",
                CurrencyConversionBean.class,
                params);
        CurrencyConversionBean responseBean = responseEntity.getBody();
        responseBean.setConversionMultiple(responseBean.getConversionMultiple());
        responseBean.setQuantityFrom(quantity);
        responseBean.setQuantityTo(quantity.multiply(responseBean.getConversionMultiple()));
        return responseBean;
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/{quantity}")
    public CurrencyConversionBean convertCurrencyWithFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        CurrencyConversionBean conversionBean = currencyExchangeServiceProxy.exchange(from, to);
        conversionBean.setQuantityFrom(quantity);
        conversionBean.calculate();
        return conversionBean;
    }
}
