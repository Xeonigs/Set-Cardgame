import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        addCards();
        shuffleCards();
    }

    public Card[] pickThreeCards() {
        Card[] cards = {this.cards.get(0), this.cards.get(1), this.cards.get(2)};
        for (Card card : cards)
            this.cards.remove(card);
        return cards;
    }

    private void addCards() {
        for (Color color : Color.values())
            for (Symbol symbol : Symbol.values())
                for (Number number : Number.values())
                    for (Shading shading : Shading.values())
                        cards.add(new Card(color, symbol, number, shading));
    }

    private void shuffleCards() {
        Collections.shuffle(cards);
    }

    public int getCardsInDeck() {
        return cards.toArray().length;
    }

    public void resetDeck(Table table, Player player) {
        removeCards(table, player);
        addCards();
        shuffleCards();
        for (int i = 0; i < 4; i++)
            table.addThreeCards(pickThreeCards());
    }

    private void removeCards(Table table, Player player) {
        table.clearDeck();
        player.clearPlayersCard();
        cards.clear();
    }
}
