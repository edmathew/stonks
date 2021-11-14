package com.ejpm.stonks.degiro;

import java.io.File;

public class TestUtils {

  public static File readFileFromResources(final String fileName) {
    final ClassLoader classLoader = TestUtils.class.getClassLoader();
    return new File(classLoader.getResource(fileName).getFile());
  }
}
