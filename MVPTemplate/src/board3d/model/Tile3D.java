package board3d.model;

//import javafx.scene.layout.StackPane;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Tile3D {
//    private StackPane pane;
//    private List<Piece3D> pieces;
//
//    public Tile3D() {
//        pane = new StackPane();
//        pane.setMinSize(70, 70);
//        pieces = new ArrayList<>();
//    }
//
//    public void addPiece(Piece3D piece) {
//        pieces.add(piece);
//        updatePiecePositions();
//        pane.getChildren().add(piece);
//    }
//
//    private void updatePiecePositions() {
//        for (int i = 0; i < pieces.size(); i++) {
//            Piece3D piece = pieces.get(i);
//            piece.setTranslateZ(-piece.getPieceDepth() * (pieces.size() - 1 - i));
//        }
//    }
//
//    public StackPane getPane() {
//        return pane;
//    }
//
//    public List<Piece3D> getPieces() {
//        return pieces;
//    }
//}

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;

public class Tile3D extends StackPane {

    public Tile3D() {
        this.setPrefSize(50,50);
        this.setAlignment(Pos.CENTER);
    }

    public void addPiece(Piece3D piece) {
        this.getChildren().add(piece);
    }
}

