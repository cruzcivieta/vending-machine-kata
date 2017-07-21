import java.util.Map;

public class Storage {

    private Map<Code, StorageItem> storage;

    public Storage(Map<Code, StorageItem> storage) {
        this.storage = storage;
    }

    public Product extract(Code code, double money) throws CodeNotFound, ProductIsEmpty, MoneyIsNotEnoughException {
        if (!storage.containsKey(code)) {
            throw new CodeNotFound();
        }

        StorageItem storageItem = storage.get(code);
        if (storageItem.isEmpty()) {
            throw new ProductIsEmpty();
        }

        if (!storageItem.isAffordable(money)) {
            throw new MoneyIsNotEnoughException();
        }

        return storageItem.fetchProduct();
    }
}
