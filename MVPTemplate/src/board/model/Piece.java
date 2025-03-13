package board.model;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Piece extends Group {


    public Piece() {
        Rectangle square = new Rectangle(50, 50);
        square.setFill(Color.GREEN);
        square.setStroke(Color.BLACK);
        square.setStrokeWidth(2);

        Line line1 = new Line(0, 0, 50, 50);
        Line line2 = new Line(0, 50, 50, 0);

        line1.setStroke(Color.BLACK);
        line1.setStrokeWidth(2);
        line2.setStroke(Color.BLACK);
        line2.setStrokeWidth(2);

        this.getChildren().addAll(square, line1, line2);
    }
}
