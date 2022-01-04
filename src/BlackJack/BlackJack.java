package BlackJack;

import Model.Ace;
import Model.Card;
import Model.Player;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Simon
 */
public class BlackJack {
    
    private static List<Player> players;
    private static List<Card> deck;

    public BlackJack(List<Player> players, List<Card> d)
    {
        this.players = players;
        this.deck = d;
    }
    
    public static boolean isBlackJack(List<Card> bet)
    {
        return getPoints(bet) == 21 && bet.size() == 2;
    }
    
     public static void croupierGetCards(Player croupier){
        List<Card> deckCards = new ArrayList<>(deck);
        int i = 0;
        while (getPoints(croupier.getCards()) < 17){
           try{
               croupier.addCard(deckCards.get(i));
               i++;
           }
           catch(IndexOutOfBoundsException ex){break;}

        }
    }
    
    public static int getPoints(List<Card> bet)
    {
        int totalPoints = 0;
        int totalAces = 0;
        
        for (Card card : bet)
        {
            if(card instanceof Ace)
            {
                totalAces++;
            }
            totalPoints += card.getValue();
        }
        
        while(totalPoints > 21 && totalAces > 0)
        {
            totalPoints -= 10;
            totalAces--;
        }
        return totalPoints;
    }
    
   
    
    public List<Player> getWinners(List<Player> players, List<Card> deck){
        ArrayList<Player> winners = new ArrayList<>();
        
        for (int i=1; i<players.size(); i++){                  
            if(players.get(i).isWinner(players.get(0))){
                winners.add(players.get(i));
            }
        }
        
        return winners;
    }
    
}
