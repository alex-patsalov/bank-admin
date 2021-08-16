package application.enums;

public enum Currency {
  USD("USD"),
  EUR("EUR"),
  UAH("UAH"),
  CHF("CHF"),
  GBP("GBP");

  private final String constant;

  Currency(String constant) {
    this.constant = constant;
  }

  public String getName() {
    return constant;
  }

  public static Currency getByName(String name){
    System.out.printf("this is cuur %s\n", name);
    return Currency.valueOf(name);
  }
}