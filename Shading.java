import java.awt.Color;
import java.awt.*;

public enum Shading {
    SOLID("Solid"),
    OPEN("Open"),
    STRIPED("Striped");

    private String shading;

    Shading(String shading) {
        this.shading = shading;
    }

    public static GradientPaint getGradientPaint(Color color) {
        return new GradientPaint(0, 0,
                Color.WHITE, 5, 0, color, true);
    }

    public String getShading() {
        return shading;
    }
}
