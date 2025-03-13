package temp.model;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;


public class Tile {

    private StackPane pane;

    public Tile() {
        pane = new StackPane();
        pane.setMinSize(50,50);

        Piece bottomPiece = new Piece(30,30,30);
        Piece topPiece = new Piece(20,20,20);

        pane.getChildren().addAll(bottomPiece, topPiece);
    }

    public StackPane getPane() {
        return pane;
    }


}
