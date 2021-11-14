package com.ejpm.stonks.degiro;

import com.ejpm.stonks.core.report.PortfolioReport;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DegiroPortfolioHandlerTest {

  @Test
  public void shouldCreatePortfolioWithTwoEntries_whenLoadingTwoBuyTransactions() {
    final DegiroPortfolioHandler portfolioHandler = new DegiroPortfolioHandler();
    portfolioHandler.loadPortfolio(TestUtils.readFileFromResources("example-degiro-1.csv"));

    System.out.println(new PortfolioReport().generateReport(portfolioHandler.getPortfolio()));
    assertThat(portfolioHandler.getPortfolio().getEntries().size()).isEqualTo(2);
  }


}