package OOP.L01_WorkingWithAbstraction.P03_CardWithPower;

public class Card {

    private RankPower cardRank;
    private SuitPower cardSuit;
    private int power;

    public Card(RankPower cardRank, SuitPower cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public RankPower getCardRank() {
        return cardRank;
    }

    public SuitPower getCardSuit() {
        return cardSuit;
    }

    public int getPower() {
        this.power = this.cardSuit.getPower() + this.cardRank.getPower();
        return power;
    }
}
