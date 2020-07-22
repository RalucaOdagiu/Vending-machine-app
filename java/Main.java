import java.util.List;
import java.util.Map;

public class Main {


  public static void main(String[] args) {
    Map<String, List<Coin>> coinStock = null;
    VendingMachine vendingMachine = new VendingMachine(coinStock);
    vendingMachine.load();
    vendingMachine.start();
  }
}
