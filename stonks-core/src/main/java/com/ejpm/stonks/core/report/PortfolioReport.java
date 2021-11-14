package com.ejpm.stonks.core.report;

import com.ejpm.stonks.core.entities.PortfolioEntry;
import com.ejpm.stonks.core.portfolio.Portfolio;

public class PortfolioReport {

  public String generateReport(final Portfolio portfolio) {
    final StringBuilder builder = new StringBuilder();
    for (PortfolioEntry entry : portfolio.getEntries())
      builder.append(entryLine(entry)).append("\n");
    return builder.toString();
  }

  private String entryLine(final PortfolioEntry entry) {
    return new StringBuilder()
            .append(entry.getProduct())
            .append("\t")
            .append(entry.getTotalQuantity())
            .append("\t")
            .append(entry.getPositionValue())
            .toString();
  }
}
