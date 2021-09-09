import java.awt.geom.Path2D;

public class Diamond extends Path2D.Double {
    public Diamond() {
        moveTo(0, Symbol.HEIGHT / 2);
        lineTo(Symbol.WIDTH / 2, 0);
        lineTo(Symbol.WIDTH, Symbol.HEIGHT / 2);
        lineTo(Symbol.WIDTH / 2, Symbol.HEIGHT);
        closePath();
    }
}