public enum Number {
    ONE(1),
    TWO(2),
    THREE(3);

    private int number;

    Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
