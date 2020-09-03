import java.util.*;

public class Runner {
    public static void main(String[] args) {

        System.out.println("Blackjack!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter player number?");
        int numberOfPlayers = scanner.nextInt();

        ArrayList<Player> players = new ArrayList<Player>();
        for (int i = 1; i <= numberOfPlayers; i++){
            scanner = new Scanner(System.in);
            System.out.println(String.format("Player %s, what is your name?", i));
            String name = scanner.nextLine();
            players.add(new Player(name));
        }

        Blackjack blackjack = new Blackjack(players);
        blackjack.populateDeck();
        blackjack.dealCards();

        for (Player player : players){
            for (Card card : player.getCards()){
                System.out.println(String.format("%s has been dealt the %s of %s.",
                        player.getName(),
                        card.getRank(),
                        card.getSuit()));
            }
        }

        for (Card card : blackjack.getDealer().getCards()){
            System.out.println(String.format("Dealer has been dealt the %s of %s.",
                    card.getRank(),
                    card.getSuit()));
        }

        for (Player player : players){
            System.out.println(String.format("%s, you have a total of %d. What would you like to do? (hit/stand)",
                    player.getName(),
                    player.getCardTotal()));
            scanner = new Scanner(System.in);
            String nextMove = scanner.nextLine();
            if (nextMove.equals("hit")){
                blackjack.playerHit(player);
            } else if (nextMove.equals("stand")){
                //standed
            }
        }
        HashMap<Player, Integer> playerIntegerHashMap = new HashMap<>();
        players.stream().forEach(player -> {
            playerIntegerHashMap.put(player,  Math.abs(player.getCardTotal() - 21));
        });
        System.out.println("Winner is: " +
                Collections.max(playerIntegerHashMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey());
    }

}
