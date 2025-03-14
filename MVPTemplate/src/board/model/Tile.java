package board.model;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;

public class Tile extends StackPane {

    public Tile() {
        this.setPrefSize(50,50);
        this.setAlignment(Pos.CENTER);
    }

    public void addPiece(Piece piece) {
        this.getChildren().add(piece);
    }
}
