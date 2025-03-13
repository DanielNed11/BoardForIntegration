package board.model;

import javafx.scene.layout.Pane;

public class Tile extends Pane {

    private Piece piece;

    public Tile() {
        piece = new Piece();
        this.getChildren().add(piece);

    }
}
