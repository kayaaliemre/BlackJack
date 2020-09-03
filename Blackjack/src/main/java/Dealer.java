import java.util.ArrayList;

public class Dealer {

    private ArrayList<Card> cards;

    public Dealer() {
        this.cards = new ArrayList<Card>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    public int getCardTotal(){
        int cardTotal = 0;
        for (Card card : this.cards){
            cardTotal += card.getPrimaryValue();
        }
        return cardTotal;
    }

}
