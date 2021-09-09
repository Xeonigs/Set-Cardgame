import java.awt.geom.Path2D;

public class Squiggle extends Path2D.Double {
    public Squiggle() {
        moveTo(15, Symbol.HEIGHT);
        quadTo(-10, 20, 40, 5);
        quadTo(95, 25, 130, 0);
        quadTo(Symbol.WIDTH + 15, 0, Symbol.WIDTH - 10, Symbol.HEIGHT - 20);
        quadTo(Symbol.WIDTH - 20, Symbol.HEIGHT, Symbol.WIDTH / 2, Symbol.HEIGHT);
        quadTo(30, Symbol.HEIGHT - 20, 15, Symbol.HEIGHT);
        //quadTo(Symbol.WIDTH - 40, Symbol.HEIGHT - 5, 15, Symbol.HEIGHT);

        //moveTo(Symbol.HEIGHT - 15, 0);
        //quadTo(Symbol.WIDTH + 10, Symbol.HEIGHT - 20, Symbol.WIDTH - 40, Symbol.HEIGHT - 5);
        //quadTo(Symbol.WIDTH - 95, Symbol.HEIGHT - 25, Symbol.WIDTH - 150, Symbol.HEIGHT);
        closePath();
    }
}