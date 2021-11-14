package com.ejpm.stonks.core.entities;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Builder
public class PortfolioEntry {

  @Getter
  private String product;
  private final List<Transaction> activePositions = new ArrayList<>();

  public void addPosition(final Transaction t) {
    activePositions.add(t);
  }

  public void removePosition(final Transaction t) {
    int quantityToRemove = t.getQuantity() * -1;
    while (quantityToRemove > 0) {
      final Transaction firstEntry = activePositions.get(0);
      if (firstEntry.getQuantity() < quantityToRemove) {
        activePositions.remove(0);
        quantityToRemove = quantityToRemove - firstEntry.getQuantity();
      } else {
        firstEntry.setQuantity(firstEntry.getQuantity() - quantityToRemove);
        quantityToRemove = 0;
      }
    }
  }

  public BigDecimal getPositionValue() {
    return activePositions.stream().map(t -> t.getUnitPrice().multiply(new BigDecimal(t.getQuantity())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public int getTotalQuantity() {
    return activePositions.stream().map(t -> t.getQuantity())
            .reduce(0, Integer::sum);
  }

}
