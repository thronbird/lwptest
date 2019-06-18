package com.lwptest.basic.JAVA8.lambdaDesignPattern;

import java.util.function.Consumer;

//class Mailer {
//  public void from(String addr) { System.out.println("from"); }
//  public void to(String addr) { System.out.println("to"); }
//  public void subject(String subjectLine) { System.out.println("subject"); }
//  public void body(String message) { System.out.println("body"); }
//  public void send() { System.out.println("sending..."); }
//}
//public class com.lwptest.basic.JAVA8.lambdaDesignPattern.LightweightStrategy {
//  public static void main(String[] args) {
//    Mailer mailer = new Mailer();
//    mailer.from("builder@agiledeveloper.com");
//    mailer.to("venkats@agiledeveloper.com");
//    mailer.subject("Your code sucks");
//    mailer.body("...");
//    mailer.send();
//  }
//}


class Mailer {
  public Mailer from(String addr) { System.out.println("from"); return this; }
  public Mailer to(String addr) { System.out.println("to"); return this; }
  public Mailer subject(String subjectLine) { System.out.println("subject"); return this; }
  public Mailer body(String message) { System.out.println("body"); return this; }
  public static void send(Consumer<Mailer> block) {
    Mailer mailer = new Mailer();
    block.accept(mailer);
    System.out.println("sending...");
  }
  public static void main(String[] args) {
    Mailer.send(mailer -> {
      mailer.from("builder@agiledeveloper.com")
              .to("venkats@agiledeveloper.com")
              .subject("Your code sucks")
              .body("...");
    });
  }
}


