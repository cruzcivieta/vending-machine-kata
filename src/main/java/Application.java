public class Application {

    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        System.out.println("Price for A1: " + vm.price(Code.from(1, "A")));
        try {
            System.out.println("Buy for A1: " + vm.fetch(5,Code.from(1, "A")));
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }

        System.out.println("Change for A1: " + vm.returnChange(5, "A1"));

        try {
            System.out.println("Buy for A1: " + vm.fetch(5,Code.from(1, "A")));
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }

        try {
            System.out.println("Buy for A1: " + vm.fetch(5,Code.from(1, "A")));
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }

        try {
            System.out.println("Buy for A1: " + vm.fetch(5,Code.from(1, "A")));
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }


    }

}
