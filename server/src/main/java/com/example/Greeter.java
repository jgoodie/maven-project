package com.example;

/**
 * This is a class.
 * blah blah blah
 */
public class Greeter {

  /**
   * This is a constructor.
   */
  public Greeter() {

  }

 /**
  * @param someone the name of a person
  * @return greeting string
  */

  public final String greet(final String someone) {
    return String.format("Hello stinky, %s!", someone);
  }
}
