import java.awt.geom.Path2D;

public class Oval extends Path2D.Double {
    public Oval() {
        double radius = Symbol.HEIGHT / 2;
        moveTo(radius, 0);
        lineTo(Symbol.WIDTH - radius, 0);
        curveTo(Symbol.WIDTH - radius, 0, Symbol.WIDTH + radius, radius, Symbol.WIDTH - radius, Symbol.HEIGHT);
        lineTo(radius, Symbol.HEIGHT);
        curveTo(radius, Symbol.HEIGHT, 0 - radius, radius, radius, 0);
        closePath();
    }
}
