package com.ejpm.stonks.degiro.entity;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@ToString
public class DegiroCSVEntry {

  @CsvBindByPosition(position = 0)
  @Getter
  @Setter
  @CsvDate(value="dd-MM-yyyy")
  private LocalDate date;

  @CsvBindByPosition(position = 1)
  @Getter
  @Setter
  private String time;

  @CsvBindByPosition(position = 2)
  @Getter
  @Setter
  private String product;

  @CsvBindByPosition(position = 3)
  @Getter
  @Setter
  private String isin;

  @CsvBindByPosition(position = 4)
  @Getter
  @Setter
  private String market;

  @CsvBindByPosition(position = 5)
  @Getter
  @Setter
  private String market2;

  @CsvBindByPosition(position = 6)
  @Getter
  @Setter
  private int quantity;

  @CsvBindByPosition(position = 7)
  @Getter
  @Setter
  private BigDecimal unitPrice;

  @CsvBindByPosition(position = 8)
  @Getter
  @Setter
  private String unitPriceLocalCurrency;

  @CsvBindByPosition(position = 9)
  @Getter
  @Setter
  private BigDecimal totalPrice;

  @CsvBindByPosition(position = 10)
  @Getter
  @Setter
  private String totalPriceLocalCurrency;

  @CsvBindByPosition(position = 11)
  @Getter
  @Setter
  private BigDecimal totalValue;

  @CsvBindByPosition(position = 12)
  @Getter
  @Setter
  private String totalValueBrokerCurrency;

  @CsvBindByPosition(position = 13)
  @Getter
  @Setter
  private BigDecimal exchangeRate;

  @CsvBindByPosition(position = 14)
  @Getter
  @Setter
  private BigDecimal transactionCosts;

  @CsvBindByPosition(position = 15)
  @Getter
  @Setter
  private String transactionCostsCurrency;

  @CsvBindByPosition(position = 16)
  @Getter
  @Setter
  private BigDecimal totalTransactionValue;

  @CsvBindByPosition(position = 17)
  @Getter
  @Setter
  private String totalTransactionValueCurrency;

  @CsvBindByPosition(position = 18)
  @Getter
  @Setter
  private String orderId;

}
