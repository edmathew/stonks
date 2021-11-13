package com.ejpm.stonks.core.portfolio;

import com.ejpm.stonks.core.entities.PortfolioEntry;
import com.ejpm.stonks.core.entities.Transaction;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static com.ejpm.stonks.core.entities.Transaction.TransactionType.BUY;
import static com.ejpm.stonks.core.entities.Transaction.TransactionType.SELL;
import static org.assertj.core.api.Assertions.assertThat;

public class PortfolioTest {

  private final Portfolio portfolio = new Portfolio();

  @Test
  public void shouldReturnWealthZero_whenPortfolioIsEmpty() {
    assertThat(portfolio.portfolioValue()).isZero();
  }

  @Test
  public void afterAddingATransaction_wealthIsTheValueOfTheTransaction() {
    final Transaction t = generateTransaction(BUY,"4.346", 20, "A");
    portfolio.applyToPortfolio(t);
    assertThat(portfolio.portfolioValue()).isEqualTo(t.getTotalPrice());
  }

  @Test
  public void afterAddingTwoTransactions_wealthIsTheSumOfAllTheTransactions() {
    final Transaction t1 = generateTransaction(BUY,"4.346", 20, "A");
    final Transaction t2 = generateTransaction(BUY,"2.84", 30, "A");

    portfolio.applyToPortfolio(t1);
    portfolio.applyToPortfolio(t2);

    final BigDecimal totalTransactionAmount = t1.getTotalPrice().add(t2.getTotalPrice());
    assertThat(portfolio.portfolioValue()).isEqualTo(totalTransactionAmount);
  }

  @Test
  public void afterSellingPosition_portfolioValueIsZero() {
    final Transaction t1 = generateTransaction(BUY, "4.346", 20, "B");
    final Transaction t2 = generateTransaction(SELL,"4.346", 20, "B");

    portfolio.applyToPortfolio(t1);
    portfolio.applyToPortfolio(t2);

    assertThat(portfolio.portfolioValue()).isZero();
  }

  @Test
  public void afterBuyingTwoDifferentStocks_shouldHaveTwoPortfolioEntries(){
    final Transaction t1 = generateTransaction(BUY, "4.346", 20, "A");
    final Transaction t2 = generateTransaction(BUY,"2.84", 30, "B");

    portfolio.applyToPortfolio(t1);
    portfolio.applyToPortfolio(t2);

    final List<PortfolioEntry> currentEntries = portfolio.getEntries();
    assertThat(currentEntries.size()).isEqualTo(2);
  }

  @Test
  public void afterSellingHalfPosition_shouldHaveOnePortfolioEntryWithTheRemainValue(){
    final Transaction t1 = generateTransaction(BUY, "4.346", 20, "A");
    final Transaction t2 = generateTransaction(SELL, "5", 10, "A");

    portfolio.applyToPortfolio(t1);
    portfolio.applyToPortfolio(t2);

    final List<PortfolioEntry> currentEntries = portfolio.getEntries();
    assertThat(currentEntries.size()).isEqualTo(1);
    assertThat(currentEntries.get(0).getTotalQuantity()).isEqualTo(10);
    assertThat(currentEntries.get(0).getPositionValue()).isEqualTo(new BigDecimal("43.460"));
  }


  public Transaction generateTransaction(Transaction.TransactionType type, String unitValueTx, int quantity, final String productName) {
    final BigDecimal unitPrice = new BigDecimal(unitValueTx);

    return Transaction.builder()
            .date(LocalDate.of(2018, 8, 17))
            .quantity(quantity)
            .type(type)
            .productName(productName)
            .unitPrice(unitPrice)
            .totalPrice(unitPrice.multiply(new BigDecimal(quantity)))
            .build();
  }


}