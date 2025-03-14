package board.model;

import javafx.scene.paint.Color;

public enum PieceColor {

    BLUE(Color.BLUE),
    RED(Color.RED),
    GREEN(Color.GREEN),
    YELLOW(Color.YELLOW),
    BLACK(Color.BLACK);

    private final Color color;

    PieceColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
