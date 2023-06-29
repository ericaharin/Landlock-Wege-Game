import java.util.LinkedList;
import java.util.Collections;


public class Deck {
    private LinkedList<WegeCard> deck = new LinkedList<WegeCard>();


    /**
     * create all the cards for the game & shuffle them each time
     * @param number of each card type if inputted
     */
    public Deck(int numberCards) {
        for (int i = 0; i < numberCards; i++){
            deck.add(new WegeCard(WegeCard.CardType.LAND, false, false));
        }
        for (int i = 0; i < numberCards; i++){
            deck.add(new WegeCard(WegeCard.CardType.WATER, false, false));
        }
        for (int i = 0; i < numberCards; i++){
            deck.add(new WegeCard(WegeCard.CardType.LAND, true, true));
        }
        for (int i = 0; i < numberCards; i++){
            deck.add(new WegeCard(WegeCard.CardType.LAND, true, false));
        }
        for (int i = 0; i < numberCards; i++){
            deck.add(new WegeCard(WegeCard.CardType.WATER, true, true));
        }
        for (int i = 0; i < numberCards; i++){
            deck.add(new WegeCard(WegeCard.CardType.WATER, true, false));
        }
        for (int i = 0; i < numberCards; i++){
            deck.add(new WegeCard(WegeCard.CardType.COSSACK, false, false));
        }
        for (int i = 0; i < numberCards; i++){
            deck.add(new WegeCard(WegeCard.CardType.BRIDGE, false, false));
        }

        Collections.shuffle(deck);

    }

    /**
     * create all the cards for the game & shuffle them each time
     */
    public Deck() {
        for (int i = 0; i < 12; i++){
            deck.add(new WegeCard(WegeCard.CardType.LAND, false, false));
        }
        for (int i = 0; i < 12; i++){
            deck.add(new WegeCard(WegeCard.CardType.WATER, false, false));
        }
        for (int i = 0; i < 3; i++){
            deck.add(new WegeCard(WegeCard.CardType.LAND, true, true));
        }
        for (int i = 0; i < 2; i++){
            deck.add(new WegeCard(WegeCard.CardType.LAND, true, false));
        }
        for (int i = 0; i < 3; i++){
            deck.add(new WegeCard(WegeCard.CardType.WATER, true, true));
        }
        for (int i = 0; i < 2; i++){
            deck.add(new WegeCard(WegeCard.CardType.WATER, true, false));
        }
        for (int i = 0; i < 3; i++){
            deck.add(new WegeCard(WegeCard.CardType.COSSACK, false, false));
        }
        for (int i = 0; i < 3; i++){
            deck.add(new WegeCard(WegeCard.CardType.BRIDGE, false, false));
        }

        Collections.shuffle(deck);
    }

    /* get method to retrieve the deck
     */
    public LinkedList<WegeCard> getDeck(){
        return this.deck;
    }

}
