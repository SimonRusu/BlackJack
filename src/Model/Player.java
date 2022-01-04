package Model;

/**
 *
 * @author Simon
 */
import BlackJack.BlackJack;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private int num;
    private final List<Card> bet = new ArrayList<>();

    public Player(int num) {this.num = num;}
    
    public void addCard(Card card)
    {
        bet.add(card);
    }

    public List<Card> getCards() 
    {
        return bet;
    }
    
    public boolean isWinner(Player croupier)
    {
        BlackJack.croupierGetCards(croupier);
        int croupierAmount = BlackJack.getPoints(croupier.getCards());
        int playerAmount = BlackJack.getPoints(this.bet);

        if(playerAmount > 21 || BlackJack.isBlackJack(croupier.getCards())) 
        {
            return false;
        }

        if(croupierAmount > 21 || playerAmount > croupierAmount) 
        {
            return true;
        }
        
        return false; 
    }

    @Override
    public String toString() {
        return "Jugador "+num+" {" + "bet=" + BlackJack.getPoints(bet) + '}';
    }
    
    
    
}
