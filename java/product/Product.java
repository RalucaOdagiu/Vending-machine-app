package product;

public enum Product {

  COLA("Cola", "A001", 3),
  DORNA("Dorna", "A002", 2),
  SNICKERS("Snickers", "A003", 4),
  FANTA("FantaMadnes", "A004", 8);

  private String name;
  private String code;
  private int price;

  Product(String name, String code, int price) {
    this.name = name;
    this.code = code;
    this.price = price;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}
