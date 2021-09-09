import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public enum Symbol {
    OVAL(new Oval()),
    SQUIGGLE(new Squiggle()),
    DIAMOND(new Diamond());

    public static final int WIDTH = Card.WIDTH - 20;
    public static final int HEIGHT = Card.HEIGHT / 4;
    private Path2D.Double aDouble;

    Symbol(Path2D.Double aDouble) {
        this.aDouble = aDouble;
    }

    public Shape getShape(int x, int y) {
        x -= WIDTH / 2;
        y -= HEIGHT / 2;
        AffineTransform affineTransform = AffineTransform.getTranslateInstance(x, y);
        Shape shape = affineTransform.createTransformedShape(aDouble);
        return shape;
    }
}
