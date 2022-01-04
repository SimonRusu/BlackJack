package BlackJack;

import Model.Ace;
import Model.Card;
import Model.Jack;
import Model.King;
import Model.PipCard;
import Model.Player;
import Model.Queen;
import java.util.ArrayList;
import java.util.List;

public class main {
        
    public static void main(String[] args)
    {
        test1();
        test2();
        test3();
        test4();
    }
    
    public static void addPlayers(int num, List<Player> players){
        for(int i=0; i<=num; i++){
            Player p = new Player(i);
            players.add(p);
        }
    }
    
    public static void test1()
    {
        List<Player> players = new ArrayList<>();
        List<Card> deck = new ArrayList<>();
        
        addPlayers(3, players);
        
        //Croupier
        players.get(0).addCard(new Jack());
        players.get(0).addCard(new PipCard(5));
        deck.add(new Ace());
        deck.add(new Jack());
        
        //Players
        players.get(1).addCard(new PipCard(6));
        players.get(1).addCard(new PipCard(5));
        players.get(1).addCard(new Ace());
        
        players.get(2).addCard(new Ace());
        players.get(2).addCard(new King());
        
        players.get(3).addCard(new Jack());
        players.get(3).addCard(new PipCard(10));

        BlackJack blackjack = new BlackJack(players, deck);
        List<Player> winners = blackjack.getWinners(players, deck);
        
        System.out.println("- Test 1: El croupier excede 21 y los 3 jugadores se mantienen por debajo.");
        System.out.println(winners);
    }
    
    public static void test2()
    {
        List<Player> players = new ArrayList<>();
        List<Card> deck = new ArrayList<>();
        
        addPlayers(3, players);
        
        //Croupier
        players.get(0).addCard(new Jack());
        players.get(0).addCard(new Ace());
        deck.add(new PipCard(5));
        
        //Players
        players.get(1).addCard(new PipCard(6));
        players.get(1).addCard(new PipCard(5));
        players.get(1).addCard(new Ace());
        
        players.get(2).addCard(new Ace());
        players.get(2).addCard(new King());
        
        players.get(3).addCard(new Jack());
        players.get(3).addCard(new PipCard(10));
        
        BlackJack blackjack = new BlackJack(players, deck);
        List<Player> winners = blackjack.getWinners(players, deck);
        
        System.out.println("\n- Test 2: El croupier hace BlackJack y los 3 jugadores pierden.");
        System.out.println(winners);
    }
    
    public static void test3()
    {
        List<Player> players = new ArrayList<>();
        List<Card> deck = new ArrayList<>();
        
        addPlayers(3, players);
        
        //Croupier
        players.get(0).addCard(new PipCard(5));
        players.get(0).addCard(new PipCard(5));
        deck.add(new PipCard(2));
        deck.add(new PipCard(7));
        
        //Players
        players.get(1).addCard(new PipCard(6));
        players.get(1).addCard(new PipCard(5));
        players.get(1).addCard(new Ace());
        players.get(1).addCard(new Jack());
        
        players.get(2).addCard(new Ace());
        players.get(2).addCard(new King());
        
        players.get(3).addCard(new PipCard(3));
        players.get(3).addCard(new Jack());
        
        BlackJack blackjack = new BlackJack(players, deck);
        List<Player> winners = blackjack.getWinners(players, deck);
        
        System.out.println("\n- Test 3: El croupier se mantiene por debajo de 21, el jugador 1 excede 21"
                + ", el jugador 2 hace BlackJack y el jugador 3 se mantiene por debajo del croupier.");
        System.out.println(winners);
    }
    
    public static void test4()
    {
        List<Player> players = new ArrayList<>();
        List<Card> deck = new ArrayList<>();
        
        addPlayers(6, players);
        
        //Croupier
        players.get(0).addCard(new Queen());
        players.get(0).addCard(new PipCard(4));
        deck.add(new PipCard(3));
        deck.add(new PipCard(7));
        
        //Players
        players.get(1).addCard(new PipCard(6));
        players.get(1).addCard(new Jack());
        players.get(1).addCard(new PipCard(3));
        
        players.get(2).addCard(new Queen());
        players.get(2).addCard(new PipCard(5));
        
        players.get(3).addCard(new Jack());
        players.get(3).addCard(new PipCard(6));
        
        players.get(4).addCard(new Queen());
        players.get(4).addCard(new King());
        
        players.get(5).addCard(new Queen());
        players.get(5).addCard(new Ace());
        
        players.get(6).addCard(new Ace());
        players.get(6).addCard(new PipCard(4));
        
        BlackJack blackjack = new BlackJack(players, deck);
        List<Player> winners = blackjack.getWinners(players, deck);
        
        System.out.println("\n- Test 4: Croupier: 17 puntos; P1: Gana; P2: Pierde; P3: Pierde; P4: Gana; P5: Gana; P6: Pierde");
        System.out.println(winners);
    }
}
