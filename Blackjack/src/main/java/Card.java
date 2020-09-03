public class Card {

    private SuitType suit;
    private RankType rank;

    public Card(SuitType suitType, RankType rankType){
        this.suit = suitType;
        this.rank = rankType;
    }

    public SuitType getSuit() {
        return suit;
    }

    public RankType getRank() {
        return rank;
    }

    public int getPrimaryValue() {
        return rank.getPrimaryValue();
    }

}
