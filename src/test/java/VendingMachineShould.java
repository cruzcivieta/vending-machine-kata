import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.*;

@RunWith(Parameterized.class)
public class VendingMachineShould {

    private String code;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "5F" }, { "f5" }
        });
    }

    public VendingMachineShould(String code) {
        this.code = code;
    }

    @Test
    public void cancel_action_when_the_code_is_not_valid() {
        String notValidCode = this.code;
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

    @Test
    public void retrieve_the_selected_can() {
        String validCode = "A1";
        Double validMoney = 2.8;
        VendingMachine vendingMachine = new VendingMachine();

        String result = vendingMachine.fetch(validMoney, validCode);

        assertThat(result).isEqualTo("Yellow Monster");
    }

    @Test
    public void warn_when_there_are_no_cans_for_the_code() {
        String validCode = "A0";
        Double validMoney = 2.8;
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.fetch(validMoney, validCode);
        String result = vendingMachine.fetch(validMoney, validCode);

        assertThat(result).isEqualTo("There are no products for code");
    }
}