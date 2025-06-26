package OOP.L01_WorkingWithAbstraction.P03_CardWithPower;

public enum SuitPower {

    //suit power -> CLUBS - 0, DIAMONDS - 13, HEARTS - 26, SPADES - 39

    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int power;

    SuitPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
