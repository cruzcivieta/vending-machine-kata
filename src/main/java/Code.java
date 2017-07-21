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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Code)) return false;

        Code code = (Code) o;

        return getNumber().equals(code.getNumber())
                && getLetter().equals(code.getLetter());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
