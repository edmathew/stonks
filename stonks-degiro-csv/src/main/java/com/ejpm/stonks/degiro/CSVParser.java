package com.ejpm.stonks.degiro;

import com.ejpm.stonks.degiro.entity.DegiroCSVEntry;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CSVParser {

  public List<DegiroCSVEntry> readEntriesFromFile(final File degiroCSVFile) {
    try {
      return new CsvToBeanBuilder<DegiroCSVEntry>(new FileReader(degiroCSVFile))
              .withType(DegiroCSVEntry.class)
              .withSkipLines(1)
              .build()
              .parse();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
