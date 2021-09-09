import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Card {
    public static final int WIDTH = 160;
    public static final int HEIGHT = 250;
    private Color color;
    private Symbol symbol;
    private Number number;
    private Shading shading;
    private int x;
    private int y;
    private boolean isSelected;
    private boolean isSearched;

    public Card(Color color, Symbol symbol, Number number, Shading shading) {
        this.color = color;
        this.symbol = symbol;
        this.number = number;
        this.shading = shading;
        this.x = 0;
        this.y = 0;
        isSelected = false;
        isSearched = false;
    }

    public static boolean checkForSet(Card[] cards) {
        return checkForColor(cards[0], cards[1], cards[2]) && checkForSymbol(cards[0], cards[1], cards[2]) && checkForNumber(cards[0], cards[1], cards[2]) && checkForShading(cards[0], cards[1], cards[2]);
    }

    private static boolean checkForColor(Card c1, Card c2, Card c3) {
        return (c1.color == c2.color && c2.color == c3.color) || (c1.color != c2.color && c2.color != c3.color && c1.color != c3.color);
    }

    private static boolean checkForSymbol(Card c1, Card c2, Card c3) {
        return (c1.symbol == c2.symbol && c2.symbol == c3.symbol) || (c1.symbol != c2.symbol && c2.symbol != c3.symbol && c1.symbol != c3.symbol);
    }

    private static boolean checkForNumber(Card c1, Card c2, Card c3) {
        return (c1.number == c2.number && c2.number == c3.number) || (c1.number != c2.number && c2.number != c3.number && c1.number != c3.number);
    }

    private static boolean checkForShading(Card c1, Card c2, Card c3) {
        return (c1.shading == c2.shading && c2.shading == c3.shading) || (c1.shading != c2.shading && c2.shading != c3.shading && c1.shading != c3.shading);
    }

    public void drawCard(int x, int y, Graphics2D graphics2D) {
        this.x = x;
        this.y = y;
        if (isSelected) {
            graphics2D.setColor(java.awt.Color.LIGHT_GRAY);
            graphics2D.fillRoundRect(x, y, WIDTH, HEIGHT, 15, 15);
        } else if (isSearched) {
            graphics2D.setColor(java.awt.Color.CYAN);
            graphics2D.fillRoundRect(x, y, WIDTH, HEIGHT, 15, 15);
        }
        graphics2D.setColor(java.awt.Color.BLACK);
        graphics2D.draw(new RoundRectangle2D.Double(x, y, WIDTH, HEIGHT, 15, 15));


        graphics2D.setColor(getColor().getJavaColor());
        for (int i = 0; i < number.getNumber(); i++) {
            int startDiff = i * (Symbol.HEIGHT + 5);
            switch (shading) {
                case OPEN:
                    graphics2D.draw(symbol.getShape(x + WIDTH / 2, y + HEIGHT / 2 + startDiff - (number.getNumber() - 1) * Symbol.HEIGHT / 2));
                    break;
                case SOLID:
                    graphics2D.fill(symbol.getShape(x + WIDTH / 2, y + HEIGHT / 2 + startDiff - (number.getNumber() - 1) * Symbol.HEIGHT / 2));
                    break;
                case STRIPED:
                    graphics2D.setPaint(Shading.getGradientPaint(getColor().getJavaColor()));
                    graphics2D.fill(symbol.getShape(x + WIDTH / 2, y + HEIGHT / 2 + startDiff - (number.getNumber() - 1) * Symbol.HEIGHT / 2));
                    graphics2D.setColor(getColor().getJavaColor());
                    graphics2D.draw(symbol.getShape(x + WIDTH / 2, y + HEIGHT / 2 + startDiff - (number.getNumber() - 1) * Symbol.HEIGHT / 2));
            }
        }

    }

    public void setSearched(boolean searched) {
        isSearched = searched;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public Number getNumber() {
        return number;
    }

    public Shading getShading() {
        return shading;
    }
}


