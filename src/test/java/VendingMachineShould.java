import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class VendingMachineShould {

    @Test
    public void cancel_action_when_the_code_is_not_valid() {
        String notValidCode = "5F";
        VendingMachine vendingMachine = new VendingMachine();

        String result = vendingMachine.fetch(0, notValidCode);

        assertThat(result).isEqualTo("Does not exist that code");
    }

    @Test
    public void cancel_action_when_user_not_introduce_the_right_money() {
        String validCode = "A1";
        Double insufficientMoney = 2.0;
        VendingMachine vendingMachine = new VendingMachine();

        String result = vendingMachine.fetch(insufficientMoney, validCode);

        assertThat(result).isEqualTo("Put more money!");
    }

}