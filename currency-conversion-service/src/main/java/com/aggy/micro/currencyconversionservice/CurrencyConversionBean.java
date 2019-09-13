package com.aggy.micro.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversionBean {

    private String currencyFrom;
    private String currencyTo;
    private BigDecimal quantityFrom;
    private BigDecimal quantityTo;
    private BigDecimal conversionMultiple;
    //to see if load balancing works
    private int port;

    public CurrencyConversionBean(String from, String to, BigDecimal quantityFrom, BigDecimal quantityTo, BigDecimal multiplier, int port) {
        this.currencyFrom = from;
        this.currencyTo = to;
        this.quantityFrom = quantityFrom;
        this.quantityTo = quantityTo;
        this.conversionMultiple = multiplier;
        this.port = port;
    }

    public CurrencyConversionBean() {
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public BigDecimal getQuantityFrom() {
        return quantityFrom;
    }

    public void setQuantityFrom(BigDecimal quantityFrom) {
        this.quantityFrom = quantityFrom;
    }

    public BigDecimal getQuantityTo() {
        return quantityTo;
    }

    public void setQuantityTo(BigDecimal quantityTo) {
        this.quantityTo = quantityTo;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void calculate() {
        setQuantityTo(quantityFrom.multiply(conversionMultiple));
    }
}
