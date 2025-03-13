package board3d.model;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;

public class Board3D extends StackPane {

    private final Tile3D[][] board = new Tile3D[5][5];
    private final int tileSize = 70;
    private final int boardSize = 350;

    public Board3D() {
        this.setMaxSize(boardSize, boardSize);
        this.setAlignment(Pos.CENTER);
        initializeTiles();
        this.setRotate(45);
        this.setScaleZ(-1);
    }

    private void initializeTiles() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                Tile3D tile = new Tile3D();
                tile.getPane().setTranslateX((col * tileSize) - (boardSize / 2 - tileSize / 2));
                tile.getPane().setTranslateY((row * tileSize) - (boardSize / 2 - tileSize / 2));
                this.getChildren().add(tile.getPane());
                board[row][col] = tile;

                Piece3D.PieceColor color = getPieceColor(row, col);
                Piece3D largePiece = new Piece3D(60, 60, 25, Piece3D.PieceSize.LARGE, color);
                tile.addPiece(largePiece);

                Piece3D smallPiece = new Piece3D(20, 20, 10, Piece3D.PieceSize.SMALL, color);
                tile.addPiece(smallPiece);

                if (isCorner(row, col)) {
                    Piece3D mediumPiece = new Piece3D(40, 40, 20, Piece3D.PieceSize.MEDIUM, getMediumPieceColor(row, col));
                    tile.addPiece(mediumPiece);
                }
            }
        }
    }

    private Piece3D.PieceColor getPieceColor(int row, int col) {
        if (isCorner(row, col)) {
            return Piece3D.PieceColor.YELLOW;
        } else {
            return Piece3D.PieceColor.BLUE;
        }
    }

    private boolean isCorner(int row, int col) {
        return (row == 0 && col == 0) || (row == 0 && col == 4) || (row == 4 && col == 0) || (row == 4 && col == 4);
    }

    private Piece3D.PieceColor getMediumPieceColor(int row, int col) {
        if (row == 0 && col == 0) return Piece3D.PieceColor.GREEN;
        if (row == 0 && col == 4) return Piece3D.PieceColor.RED;
        if (row == 4 && col == 0) return Piece3D.PieceColor.YELLOW;
        if (row == 4 && col == 4) return Piece3D.PieceColor.BLUE;
        return Piece3D.PieceColor.YELLOW; // Default, should never happen
    }
}
