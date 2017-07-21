public class StorageItem {

    private Product product;
    private int amount;

    public StorageItem(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product fetchProduct() {
        this.amount--;
        return this.product;
    }

    public boolean isAffordable(double money) {
        return product.isAffordable(money);
    }

    public boolean isEmpty() {
        return this.amount == 0;
    }
}
