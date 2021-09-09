public enum Color {
    RED(java.awt.Color.RED),
    GREEN(java.awt.Color.GREEN),
    PURPLE(java.awt.Color.MAGENTA);

    private java.awt.Color javaColor;

    Color(java.awt.Color javaColor) {
        this.javaColor = javaColor;
    }

    public java.awt.Color getJavaColor() {
        return javaColor;
    }
}
