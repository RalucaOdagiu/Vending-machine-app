import product.Product;

import java.util.List;
import java.util.Map;

public class InputValidatorService {

  public boolean validate(Map<String, List<Product>> productStock, String userInput) {
    // 1) exista sau nu codul de produs?
    boolean productCodeExists = productStock.containsKey(userInput);
    if (!productCodeExists) {
      System.out.println("Code " + userInput + " does not exist!");
      return false;
    }

    // 2) exista sau nu pe stoc un produs cu acel cod dat?
    List<Product> products = productStock.get(userInput);
    boolean productIsOnStock = products.size() > 0;
    if (!productIsOnStock) {
      System.out.println("Sorry, the product is not on stock");
      return false;
    }
    return true;
  }

}
