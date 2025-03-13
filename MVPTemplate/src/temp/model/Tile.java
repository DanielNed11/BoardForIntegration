package temp.model;

import javafx.scene.layout.StackPane;
import java.util.ArrayList;
import java.util.List;

public class Tile {
    private StackPane pane;
    private List<Piece> pieces;

    public Tile() {
        pane = new StackPane();
        pane.setMinSize(70, 70);
        pieces = new ArrayList<>();
    }

    public void addPiece(Piece piece) {
        pieces.add(piece);
        updatePiecePositions();
        pane.getChildren().add(piece);
    }

    private void updatePiecePositions() {
        for (int i = 0; i < pieces.size(); i++) {
            Piece piece = pieces.get(i);
            piece.setTranslateZ(-piece.getPieceDepth() * (pieces.size() - 1 - i));
        }
    }

    public StackPane getPane() {
        return pane;
    }

    public List<Piece> getPieces() {
        return pieces;
    }
}
