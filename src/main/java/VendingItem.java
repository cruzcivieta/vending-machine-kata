public class VendingItem {

    private Product product;
    private double change;

    public VendingItem(Product product, double moneyPaid) {
        this.product = product;
        this.change = moneyPaid - product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public double getChange() {
        return change;
    }
}
