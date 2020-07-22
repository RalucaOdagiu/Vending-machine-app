import product.Product;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IOService {

  public void displayStockMenu(Map<String, List<Product>> productStock) {
    System.out.println("Welcome!");
    System.out.println("Code\t\t Name\t\t Price");

    for (Map.Entry<String, List<Product>> unElementDinMap : productStock.entrySet()) {
      List<Product> tavitaCuProduseDeAcelasiFel = unElementDinMap.getValue(); //iau valoarea
      if (tavitaCuProduseDeAcelasiFel.size() > 0) {
        Product product = tavitaCuProduseDeAcelasiFel.get(0);
        System.out
            .println(product.getCode() + "\t\t" + product.getName() + "\t\t" + product.getPrice());
      }

    }
  }

  public String getUserInput() {
    System.out.print("Please insert your option: ");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }
}
