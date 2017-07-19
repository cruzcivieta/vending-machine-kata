import java.util.ArrayList;
import java.util.HashMap;

public class VendingMachine {

    private HashMap<String, ArrayList<String>> products;
    private HashMap<String, ArrayList<Integer>> amount;
    private HashMap<String, ArrayList<Double>> prices;


    public VendingMachine() {
        products = new HashMap<>();
        products.put("A", new ArrayList<String>() {{
            add("Yellow Monster");add("Yellow Monster");add("Black Monster");add("White Monster");add("White Monster");
        }});
        products.put("B", new ArrayList<String>() {{
            add("Blue Monster");add("Yellow Monster");add("Black Monster");add("Black Monster");add("White Monster");
        }});
        products.put("C", new ArrayList<String>() {{
            add("Yellow Monster");add("Blue Monster");add("Blue Monster");add("Yellow Monster");add("White Monster");
        }});
        products.put("D", new ArrayList<String>() {{
            add("Rock Star");add("Rock Star");add("Rock Star");add("Rock Star");add("Rock Star");
        }});
        products.put("E", new ArrayList<String>() {{
            add("Red Bull");add("Red Bull");add("Black Monster");add("Red Bull");add("Red Bull");
        }});
        products.put("F", new ArrayList<String>() {{
            add("Black Burn");add("Black Burn");add("Blue Burn");add("Blue Burn");add("Blue Burn");
        }});
        products.put("G", new ArrayList<String>() {{
            add("Red Burn");add("Red Burn");add("Red Burn");add("Blue Burn");add("Blue Burn");
        }});
        products.put("H", new ArrayList<String>() {{
            add("Yellow Burn");add("Yellow Burn");add("Yellow Burn");add("Blue Burn");add("Blue Burn");
        }});

        amount = new HashMap<>();
        amount.put("A", new ArrayList<Integer>() {{
            add(1);add(2);add(6);add(4);add(3);
        }});
        amount.put("B", new ArrayList<Integer>() {{
            add(1);add(5);add(6);add(1);add(3);
        }});
        amount.put("C", new ArrayList<Integer>() {{
            add(2);add(5);add(3);add(4);add(3);
        }});
        amount.put("D", new ArrayList<Integer>() {{
            add(3);add(5);add(6);add(4);add(3);
        }});
        amount.put("E", new ArrayList<Integer>() {{
            add(4);add(5);add(3);add(4);add(3);
        }});
        amount.put("F", new ArrayList<Integer>() {{
            add(1);add(5);add(6);add(4);add(3);
        }});
        amount.put("G", new ArrayList<Integer>() {{
            add(5);add(5);add(3);add(4);add(2);
        }});
        amount.put("H", new ArrayList<Integer>() {{
            add(1);add(5);add(6);add(4);add(3);
        }});

        prices = new HashMap<>();
        prices.put("A", new ArrayList<Double>() {{
            add(2.80);add(2.80);add(2.90);add(3.0);add(3.0);
        }});
        prices.put("B", new ArrayList<Double>() {{
            add(2.90);add(2.80);add(2.90);add(2.90);add(3.0);
        }});
        prices.put("C", new ArrayList<Double>() {{
            add(2.80);add(2.80);add(3.00);add(2.80);add(3.0);
        }});
        prices.put("D", new ArrayList<Double>() {{
            add(2.50);add(2.50);add(2.50);add(2.50);add(2.60);
        }});
        prices.put("E", new ArrayList<Double>() {{
            add(3.50);add(3.50);add(3.50);add(3.50);add(3.50);
        }});
        prices.put("F", new ArrayList<Double>() {{
            add(3.0);add(3.0);add(3.0);add(3.0);add(3.0);
        }});
        prices.put("G", new ArrayList<Double>() {{
            add(3.0);add(3.0);add(3.0);add(3.0);add(3.0);
        }});
        prices.put("H", new ArrayList<Double>() {{
            add(3.0);add(3.0);add(3.0);add(3.0);add(3.0);
        }});
    }

    public String fetch(double money, String code) {
        String l = "NONE";
        String c = "NONE";
        for (int i = 0; i < code.length(); i++) {
            if (i == 0) {
                l = String.valueOf(code.charAt(i));
            } else {
                c = String.valueOf(code.charAt(i));
            }
        }
        if (!prices.containsKey(l)) {
            return "Does not exist that code";
        }

        double value = prices.get(l).get(Integer.valueOf(c));
        if (value >= money) {
            return "Put more money!";
        }

        int lf = amount.get(l).get(Integer.valueOf(c));
        if (lf > 0) {
            Integer a = amount.get(l).get(Integer.valueOf(c));
            amount.get(l).set(Integer.valueOf(c), a - 1);

            return products.get(l).get(Integer.valueOf(c));
        } else {
            return "There are no products for code";
        }
    }

    public double returnChange(double money, String code) {
        String l = "NONE";
        String c = "NONE";
        for (int i = 0; i < code.length(); i++) {
            if (i == 0) {
                l = String.valueOf(code.charAt(i));
            } else {
                c = String.valueOf(code.charAt(i));
            }
        }
        if (prices.containsKey(l)) {
            double value = prices.get(l).get(Integer.valueOf(c));
            return money - value;
        } else {
            return 0;
        }
    }

    public double price(String code) {
        String l = "NONE";
        String c = "NONE";
        for (int i = 0; i < code.length(); i++) {
            if (i == 0) {
                l = String.valueOf(code.charAt(i));
            } else {
                c = String.valueOf(code.charAt(i));
            }
        }
        if (prices.containsKey(l)) {
            return prices.get(l).get(Integer.valueOf(c));
        } else {
            return 0;
        }
    }
}
