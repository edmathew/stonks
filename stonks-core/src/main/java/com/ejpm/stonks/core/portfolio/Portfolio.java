package com.ejpm.stonks.core.portfolio;

import com.ejpm.stonks.core.entities.PortfolioEntry;
import com.ejpm.stonks.core.entities.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.ejpm.stonks.core.entities.Transaction.TransactionType.BUY;

public class Portfolio {

  private List<PortfolioEntry> entries = new ArrayList<>();

  public void applyToPortfolio(final Transaction transaction) {
    if (BUY == transaction.getType())
      handleBuyTransaction(transaction);
    else
      handleSellTransaction(transaction);
  }

  private void handleBuyTransaction(Transaction transaction) {
    final PortfolioEntry entry = getOrCreateEntry(transaction.getProductName());
    entry.addPosition(transaction);
  }

  private void handleSellTransaction(Transaction transaction) {
    final PortfolioEntry entry = getEntry(transaction.getProductName());
    entry.removePosition(transaction);
  }

  private PortfolioEntry getOrCreateEntry(final String product) {
    final PortfolioEntry entry = getEntry(product);

    if (null != entry)
      return entry;

    return createNewPortfolioEntry(product);
  }

  private PortfolioEntry getEntry(final String product) {
    return entries.stream().filter(e -> e.getProduct().equals(product)).findFirst().orElse(null);
  }

  private PortfolioEntry createNewPortfolioEntry(String product) {
    final PortfolioEntry newEntry = PortfolioEntry.builder()
            .product(product)
            .build();

    entries.add(newEntry);
    return newEntry;
  }

  public BigDecimal portfolioValue() {
    return entries.stream().map(e -> e.getPositionValue()).reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public List<PortfolioEntry> getEntries() {
    return entries;
  }
}
