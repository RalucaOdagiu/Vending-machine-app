import product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {

  private IOService ioService = new IOService();
  private InputValidatorService inputValidatorService = new InputValidatorService();
  private PaymentService paymentService = new PaymentService();

  // key = cod produs, value = lista de produse avand acelasi cod (produse de acelasi tip)
  private Map<String, List<Product>> productStock = new HashMap();
  //asa arata un map: {<A001, [Cola, Cola, Cola]>, <A002, [Apa, Apa, Apa, Apa, Apa]>, <A003, [ ]> }

  private Map<String, List<Coin>> coinStock;

  public VendingMachine(Map<String, List<Coin>> coinStock) {
    this.coinStock = coinStock;
  }

  public void load() {
    for (Product unProdus : Product.values()) {
      List<Product> stockProdus = new ArrayList();
      for (int index = 0; index < 3; index++) {
        stockProdus.add(unProdus);
      }
      productStock.put(unProdus.getCode(), stockProdus);
    }
  }

  public void start() {
    while (true) {
      ioService.displayStockMenu(productStock);
      String userInput = ioService.getUserInput();
      if (isStopCondition(userInput)) {
        return;
      }
      processOrder(userInput);
    }
  }

  private boolean isStopCondition(String userInput) {
    if (userInput.equalsIgnoreCase("exit")) {
      return true;
    } else {
      return false;
    }
    // acelasi lucru: return userInput.equalsIgnoreCase("exit");
  }

  private void processOrder(String userInput) {
    boolean validationSuccessful = inputValidatorService.validate(productStock, userInput);
    if (!validationSuccessful) {
      return;
    }
    // daca sunt aici, inseamna ca validarea a fost facuta cu succes :)
    boolean paymentSuccessful = paymentService.processPayment();
    if (!paymentSuccessful) {
      return;
    }
    // daca sunt aici, inseamna ca paymentul a fost facut cu succes :) :)
    releaseProduct(userInput);
    System.out.println("Thank you for buying from us! Have a nice day!");
  }

  private void releaseProduct(String userInput) {
    System.out.println("Releasing product");
    List<Product> products = productStock.get(userInput);
    products.remove(0);
  }
}
