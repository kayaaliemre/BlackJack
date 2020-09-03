import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<Card>();
    }

    public String getName() {
        return name;
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

    public boolean hasBlackjack(){
        if (getCardTotal() == 21){
            return true;
        }
        else {
            return false;
        }
    }

}
