import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card[]> sets = new ArrayList<>();
    private List<Card> playerSelectedCards = new ArrayList<>();

    public void addSet(Card[] cards) {
        sets.add(cards);
    }

    public int getNumberOfSets() {
        return sets.toArray().length;
    }

    public int getNumberOfSelectedCards() {
        return playerSelectedCards.toArray().length;
    }

    public void clearPlayersCard() {
        sets.clear();
    }

    public void addSelectedCard(Card card) {
        playerSelectedCards.add(card);
    }

    public List<Card[]> getSets() {
        return sets;
    }

    public List<Card> getPlayerSelectedCards() {
        return playerSelectedCards;
    }
}
