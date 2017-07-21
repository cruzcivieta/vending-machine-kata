class Code {

    private Integer number;
    private String letter;

    private Code(Integer number, String letter) {
        this.number = number;
        this.letter = letter;
    }

    static Code from(Integer number, String letter) {
        return new Code(number, letter);
    }

    Integer getNumber() {
        return number;
    }

    String getLetter() {
        return letter;
    }
}
