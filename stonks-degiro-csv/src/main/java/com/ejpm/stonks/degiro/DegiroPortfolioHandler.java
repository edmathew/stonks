package com.ejpm.stonks.degiro;

import com.ejpm.stonks.core.entities.Transaction;
import com.ejpm.stonks.core.portfolio.Portfolio;
import com.ejpm.stonks.degiro.entity.DegiroCSVEntry;

import java.io.File;
import java.util.List;
import java.util.ListIterator;

public class DegiroPortfolioHandler {

  private final Portfolio degiroPortfolio = new Portfolio();

  public Portfolio getPortfolio() {
    return degiroPortfolio;
  }

  public void loadPortfolio(final File transactionFile) {
    final CSVParser parser = new CSVParser();
    final List<DegiroCSVEntry> transactions = parser.readEntriesFromFile(transactionFile);

    final ListIterator<DegiroCSVEntry> iterator = transactions.listIterator(transactions.size());

    while (iterator.hasPrevious())
      applyToPortfolio(iterator.previous());
  }

  private void applyToPortfolio(DegiroCSVEntry entry) {
    final Transaction t = Transaction.builder()
            .productName(entry.getProduct())
            .quantity(entry.getQuantity())
            .unitPrice(entry.getUnitPrice())
            .date(entry.getDate())
            .build();

    degiroPortfolio.applyToPortfolio(t);
  }

}
