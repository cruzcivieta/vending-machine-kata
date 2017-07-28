import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class VendingMachineShould {

    public static final Code INVALID_CODE = Code.from(1, "Z");
    public static final Code VALID_CODE = Code.from(0, "A");
    public static final Double EXACT_PRODUCT_MONEY = 2.8;
    public static final Double INSUFFICIENT_MONEY = 2.0;
    public static final Double EXCEED_MONEY = 5.0;

    @Test(expected = CodeNotFound.class)
    public void cancel_action_when_the_code_is_not_valid() throws CodeNotFound, ProductIsEmpty, MoneyIsNotEnoughException {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.fetch(0, INVALID_CODE);
    }

    @Test(expected = MoneyIsNotEnoughException.class)
    public void cancel_action_when_user_not_introduce_the_right_money() throws CodeNotFound, ProductIsEmpty, MoneyIsNotEnoughException {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.fetch(INSUFFICIENT_MONEY, VALID_CODE);
    }

    @Test
    public void retrieve_the_selected_can() throws CodeNotFound, ProductIsEmpty, MoneyIsNotEnoughException {
        VendingMachine vendingMachine = new VendingMachine();

        VendingItem result = vendingMachine.fetch(EXACT_PRODUCT_MONEY, VALID_CODE);

        assertThat(result.getProduct().getName()).isEqualTo("Yellow Monster");
    }

    @Test
    public void retrieve_the_selected_can_with_chang() throws CodeNotFound, ProductIsEmpty, MoneyIsNotEnoughException {
        VendingMachine vendingMachine = new VendingMachine();

        VendingItem result = vendingMachine.fetch(EXCEED_MONEY, VALID_CODE);

        assertThat(result.getProduct().getName()).isEqualTo("Yellow Monster");
        assertThat(result.getChange()).isEqualTo(2.2);
    }

    @Test(expected = ProductIsEmpty.class)
    public void warn_when_there_are_no_cans_for_the_code() throws CodeNotFound, ProductIsEmpty, MoneyIsNotEnoughException {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.fetch(EXACT_PRODUCT_MONEY, VALID_CODE);
        vendingMachine.fetch(EXACT_PRODUCT_MONEY, VALID_CODE);
    }

    @Test
    public void fetch_zero_when_code_is_not_valid() throws Exception {
        VendingMachine vendingMachine = new VendingMachine();

        Double price = vendingMachine.price(INVALID_CODE);

        assertThat(price).isEqualTo(0);
    }

    @Test
    public void fetch_the_price_of_product_by_existing_code() throws Exception {
        VendingMachine vendingMachine = new VendingMachine();

        Double price = vendingMachine.price(VALID_CODE);

        assertThat(price).isEqualTo(2.80);
    }
}