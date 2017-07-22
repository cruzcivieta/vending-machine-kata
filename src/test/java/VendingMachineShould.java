import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class VendingMachineShould {

    @Test(expected = CodeNotFound.class)
    public void cancel_action_when_the_code_is_not_valid() throws CodeNotFound, ProductIsEmpty, MoneyIsNotEnoughException {
        Code notValidCode = Code.from(1, "Z");
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.fetch(0, notValidCode);
    }

    @Test(expected = MoneyIsNotEnoughException.class)
    public void cancel_action_when_user_not_introduce_the_right_money() throws CodeNotFound, ProductIsEmpty, MoneyIsNotEnoughException {
        Code validCode = Code.from(1, "A");
        Double insufficientMoney = 2.0;
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.fetch(insufficientMoney, validCode);
    }

    @Test
    public void retrieve_the_selected_can() throws CodeNotFound, ProductIsEmpty, MoneyIsNotEnoughException {
        Code validCode = Code.from(1, "A");
        Double validMoney = 2.8;
        VendingMachine vendingMachine = new VendingMachine();

        String result = vendingMachine.fetch(validMoney, validCode);

        assertThat(result).isEqualTo("Yellow Monster");
    }

    @Test(expected = ProductIsEmpty.class)
    public void warn_when_there_are_no_cans_for_the_code() throws CodeNotFound, ProductIsEmpty, MoneyIsNotEnoughException {
        Code validCode = Code.from(0, "A");
        Double validMoney = 2.8;
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.fetch(validMoney, validCode);
        vendingMachine.fetch(validMoney, validCode);
    }

    @Test
    public void fetch_zero_when_code_is_not_valid() throws Exception {
        Code notValidCode = Code.from(0, "Z");
        VendingMachine vendingMachine = new VendingMachine();

        Double price = vendingMachine.price(notValidCode);

        assertThat(price).isEqualTo(0);
    }

    @Test
    public void fetch_the_price_of_product_by_existing_code() throws Exception {
        Code validCode = Code.from(0, "A");
        VendingMachine vendingMachine = new VendingMachine();

        Double price = vendingMachine.price(validCode);

        assertThat(price).isEqualTo(2.80);
    }
}