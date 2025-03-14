package board.model;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Piece extends StackPane {


    public Piece(PieceSize size, PieceColor color) {
        int sizeValue = size.getSize();

        Rectangle square = new Rectangle(sizeValue, sizeValue);
        square.setFill(color.getColor());
        square.setStroke(Color.BLACK);
        square.setStrokeWidth(2);

        Line line1 = new Line(0, 0, sizeValue - 1, sizeValue - 1);
        Line line2 = new Line(0, sizeValue - 1, sizeValue - 1, 0);

        line1.setStroke(Color.BLACK);
        line1.setStrokeWidth(2);
        line2.setStroke(Color.BLACK);
        line2.setStrokeWidth(2);

        this.getChildren().addAll(square, line1, line2);

    }
}
