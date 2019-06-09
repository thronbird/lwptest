package JAVA8.lambdaDesignPattern;

import java.util.ArrayList;
import java.util.function.Function;

class CalculateNAV {
  private Function<String, Double> _priceFinder;
  
  public CalculateNAV(Function<String, Double> priceFinder) {
    _priceFinder = priceFinder;
  }
  
  public double compute(String ticker, int stocks) {
    return stocks * _priceFinder.apply(ticker);
  }
}

class StockFetcher {
  public static double getStockPrice(String ticker) {
    System.out.println("Do real work and get the stock price...");
    return 35.55;
  }
}

public class Delegating {
  public static void main(String[] args) {
    //In test case
    CalculateNAV calculateNAV = new CalculateNAV(ticker -> 33.33);
        
    //assert
    System.out.println(calculateNAV.compute("ORCL", 100));
    
    //In production
    CalculateNAV calculateNAV2 = new CalculateNAV(StockFetcher::getStockPrice);
    System.out.println(calculateNAV2.compute("ORCL", 100));
  }
}

