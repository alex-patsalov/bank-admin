package app1.enums;

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
    return Currency.valueOf(name);
  }
}
