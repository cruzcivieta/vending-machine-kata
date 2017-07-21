import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class VendingMachineShould {

    @Test
    public void cancel_action_when_the_code_is_not_valid() {
        Code notValidCode = Code.from(1, "Z");
        VendingMachine vendingMachine = new VendingMachine();

        String result = vendingMachine.fetch(0, notValidCode);

        assertThat(result).isEqualTo("Does not exist that code");
    }

    @Test
    public void cancel_action_when_user_not_introduce_the_right_money() {
        Code validCode = Code.from(1, "A");
        Double insufficientMoney = 2.0;
        VendingMachine vendingMachine = new VendingMachine();

        String result = vendingMachine.fetch(insufficientMoney, validCode);

        assertThat(result).isEqualTo("Put more money!");
    }

    @Test
    public void retrieve_the_selected_can() {
        Code validCode = Code.from(1, "A");
        Double validMoney = 2.8;
        VendingMachine vendingMachine = new VendingMachine();

        String result = vendingMachine.fetch(validMoney, validCode);

        assertThat(result).isEqualTo("Yellow Monster");
    }

    @Test
    public void warn_when_there_are_no_cans_for_the_code() {
        Code validCode = Code.from(0, "A");
        Double validMoney = 2.8;
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.fetch(validMoney, validCode);
        String result = vendingMachine.fetch(validMoney, validCode);

        assertThat(result).isEqualTo("There are no products for code");
    }
}