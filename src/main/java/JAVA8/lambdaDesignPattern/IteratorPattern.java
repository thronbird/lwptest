package JAVA8.lambdaDesignPattern;

import java.util.*;
import java.util.stream.IntStream;

public class IteratorPattern {
  public static int factorial(int number) {
    int product = 1;
    for(int i = 1; i <= number; i++) {
      product *= i;
    }
    return product;
  }
  
  public static int factorialFunctional(int number) {
    return IntStream.rangeClosed(1, number)
                    .reduce(1, (product, index) -> product * index);
  }
  
  public static void main(String[] args) {
    System.out.println(factorial(5));
    System.out.println(factorialFunctional(5));
  }
}