import java.util.ArrayList;
import java.util.HashMap;

class VendingMachine {

    private final Storage storage;
    private HashMap<String, ArrayList<String>> products;
    private HashMap<String, ArrayList<Integer>> amount;
    private HashMap<String, ArrayList<Double>> prices;


    VendingMachine() {
        HashMap<Code, StorageItem> items = new HashMap<>();
        Product yellowMonster = new Product("Yellow Monster", 2.80);

        StorageItem storageItemA0 = new StorageItem(yellowMonster, 1);
        StorageItem storageItemA1 = new StorageItem(yellowMonster, 2);

        items.put(Code.from(0, "A"), storageItemA0);
        items.put(Code.from(1, "A"), storageItemA1);

        this.storage = new Storage(items);
    }

    VendingItem fetch(double money, Code code) throws CodeNotFound, ProductIsEmpty, MoneyIsNotEnoughException {
        Product product = this.storage.extract(code, money);
        return new VendingItem(product, money);
    }

    double price(Code code) {
        return this.storage.price(code);
    }
}
