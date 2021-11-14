package com.ejpm.stonks.degiro;

import com.ejpm.stonks.degiro.entity.DegiroCSVEntry;
import org.junit.Test;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.ejpm.stonks.degiro.TestUtils.readFileFromResources;
import static org.assertj.core.api.Assertions.*;

public class CSVParserTest {

  private final CSVParser parser = new CSVParser();
  private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  @Test
  public void shouldReturnAnEmptyList_whenReadingAnEmptyFile() {
    assertThat(parser.readEntriesFromFile(readFileFromResources("empty-file.csv"))).isEmpty();
  }

  @Test
  public void shouldReturnEntries_whenReadingFileWithContents() {
    final List<DegiroCSVEntry> fileEntries = parser.readEntriesFromFile(readFileFromResources("example-degiro-1.csv"));
    assertThat(fileEntries.size()).isEqualTo(2);
    assertThat(dateFormat.format(fileEntries.get(0).getDate())).isEqualTo("2018-08-20");
  }

}