import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private static int gap = 20;
    public Player playerOnMove = null;
    private List<Card> cardsOnTable = new ArrayList<>();

    public void update(Deck deck) {
        if (!isSetAvailable()) {
            if (deck.getCardsInDeck() > 0) {
                addThreeCards(deck.pickThreeCards());
            }
        }
        if (playerOnMove != null) {
            if (playerOnMove.getNumberOfSelectedCards() == 3) {
                Card[] cards = new Card[]{playerOnMove.getPlayerSelectedCards().get(0), playerOnMove.getPlayerSelectedCards().get(1), playerOnMove.getPlayerSelectedCards().get(2)};
                if (Card.checkForSet(cards)) {
                    playerOnMove.addSet(cards);
                    for (Card card : cards) {
                        cardsOnTable.remove(card);
                    }
                    if (getNumberOfCardsOnTable() < 12 && deck.getCardsInDeck() > 0)
                        addThreeCards(deck.pickThreeCards());
                    else if (deck.getCardsInDeck() == 0 && !isSetAvailable()) {
                        System.out.println("No Set Available");
                    }
                }
                for (Card card : cards) {
                    card.setSelected(false);
                }
                playerOnMove.getPlayerSelectedCards().clear();
            }
        }
    }

    public void addPlayerSelectedCard(MouseEvent e, Player p) {
        playerOnMove = p;
        if (playerOnMove != null) {
            for (Card card : cardsOnTable) {
                card.setSearched(false);
                if (e.getPoint().x > card.getX() && e.getPoint().x < card.getX() + Card.WIDTH && e.getPoint().y > card.getY() && e.getPoint().y < card.getY() + Card.HEIGHT) {
                    if (playerOnMove.getPlayerSelectedCards().contains(card)) {
                        playerOnMove.getPlayerSelectedCards().remove(card);
                        card.setSelected(false);
                    } else {
                        playerOnMove.addSelectedCard(card);
                        card.setSelected(true);
                    }
                }
            }
        }
    }

    public void searchForSet() {
        for (Card card : cardsOnTable) {
            card.setSearched(false);
        }
        for (int c1 = 0; c1 < cardsOnTable.toArray().length; c1++) {
            for (int c2 = c1 + 1; c2 < cardsOnTable.toArray().length; c2++) {
                for (int c3 = c2 + 1; c3 < cardsOnTable.toArray().length; c3++) {
                    if (Card.checkForSet(new Card[]{cardsOnTable.get(c1), cardsOnTable.get(c2), cardsOnTable.get(c3)})) {
                        cardsOnTable.get(c1).setSearched(true);
                        cardsOnTable.get(c2).setSearched(true);
                        cardsOnTable.get(c3).setSearched(true);
                        return;
                    }
                }
            }
        }
    }

    public void addThreeCards(Card[] cards) {
        if (!isTableFull())
            for (Card card : cards)
                cardsOnTable.add(card);
    }

    public boolean isSetAvailable() {
        boolean isSetAvailable = false;
        for (int c1 = 0; c1 < cardsOnTable.toArray().length; c1++)
            for (int c2 = c1 + 1; c2 < cardsOnTable.toArray().length; c2++)
                for (int c3 = c2 + 1; c3 < cardsOnTable.toArray().length; c3++)
                    isSetAvailable = Card.checkForSet(new Card[]{cardsOnTable.get(c1), cardsOnTable.get(c2), cardsOnTable.get(c3)}) ? true : isSetAvailable;
        return isSetAvailable;
    }

    public void paintTable(Graphics2D graphics2D) {
        for (int i = 0; i < cardsOnTable.toArray().length; i++)
            cardsOnTable.get(i).drawCard(getX(i) + 55, getY(i) + 55, graphics2D);
    }

    private int getX(int i) {
        return i / 3 * Card.WIDTH + i / 3 * gap;
    }

    private int getY(int i) {
        return i % 3 * Card.HEIGHT + i % 3 * gap;
    }

    public boolean isTableFull() {
        return cardsOnTable.toArray().length / 3 >= 7;
    }

    public int getNumberOfCardsOnTable() {
        return cardsOnTable.toArray().length;
    }

    public void clearDeck() {
        cardsOnTable.clear();
    }
}
