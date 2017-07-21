class Code {

    private Integer number;
    private String letter;

    private Code(String code) throws CodeNotValidException {
        for (int i = 0; i < code.length(); i++) {
            if (i == 0) {
                this.letter = String.valueOf(code.charAt(i));
            } else {
                try {
                    this.number = Integer.valueOf(String.valueOf(code.charAt(i)));
                } catch (NumberFormatException exception) {
                    throw new CodeNotValidException();
                }
            }
        }
    }

    static Code from(String code) throws CodeNotValidException {
        return new Code(code);
    }

    Integer getNumber() {
        return number;
    }

    String getLetter() {
        return letter;
    }
}
