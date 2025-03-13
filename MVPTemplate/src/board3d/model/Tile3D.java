package board3d.model;

import javafx.scene.layout.StackPane;
import java.util.ArrayList;
import java.util.List;

public class Tile3D {
    private StackPane pane;
    private List<Piece3D> pieces;

    public Tile3D() {
        pane = new StackPane();
        pane.setMinSize(70, 70);
        pieces = new ArrayList<>();
    }

    public void addPiece(Piece3D piece) {
        pieces.add(piece);
        updatePiecePositions();
        pane.getChildren().add(piece);
    }

    private void updatePiecePositions() {
        for (int i = 0; i < pieces.size(); i++) {
            Piece3D piece = pieces.get(i);
            piece.setTranslateZ(-piece.getPieceDepth() * (pieces.size() - 1 - i));
        }
    }

    public StackPane getPane() {
        return pane;
    }

    public List<Piece3D> getPieces() {
        return pieces;
    }
}
