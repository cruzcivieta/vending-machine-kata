class Code {

    private String number;
    private String letter;

    private Code(String code) {
        for (int i = 0; i < code.length(); i++) {
            if (i == 0) {
                this.letter = String.valueOf(code.charAt(i));
            } else {
                this.number = String.valueOf(code.charAt(i));
            }
        }
    }

    static Code from(String code) {
        return new Code(code);
    }

    String getNumber() {
        return number;
    }

    String getLetter() {
        return letter;
    }
}
