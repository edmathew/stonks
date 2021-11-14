package com.ejpm.stonks.core.entities;

import lombok.Builder;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@ToString
public class Transaction {

  private LocalDate date;
  private LocalTime time;
  private String productName;
  private int quantity;
  private BigDecimal unitPrice;


  private String isin;
  private String currency;

  private BigDecimal totalPrice;
  private BigDecimal exchangeRate;
  private BigDecimal totalPriceAfterExchange;

  private BigDecimal transactionFee;

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public LocalTime getTime() {
    return time;
  }

  public void setTime(LocalTime time) {
    this.time = time;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getIsin() {
    return isin;
  }

  public void setIsin(String isin) {
    this.isin = isin;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public BigDecimal getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(BigDecimal unitPrice) {
    this.unitPrice = unitPrice;
  }

  public BigDecimal getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(BigDecimal totalPrice) {
    this.totalPrice = totalPrice;
  }

  public BigDecimal getExchangeRate() {
    return exchangeRate;
  }

  public void setExchangeRate(BigDecimal exchangeRate) {
    this.exchangeRate = exchangeRate;
  }

  public BigDecimal getTotalPriceAfterExchange() {
    return totalPriceAfterExchange;
  }

  public void setTotalPriceAfterExchange(BigDecimal totalPriceAfterExchange) {
    this.totalPriceAfterExchange = totalPriceAfterExchange;
  }

  public BigDecimal getTransactionFee() {
    return transactionFee;
  }

  public void setTransactionFee(BigDecimal transactionFee) {
    this.transactionFee = transactionFee;
  }
}
