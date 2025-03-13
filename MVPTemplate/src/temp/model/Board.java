package temp.model;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;

public class Board extends StackPane {

    private final Tile[][] board = new Tile[5][5];
    private final int tileSize = 70;
    private final int boardSize = 350;

    public Board() {
        this.setMaxSize(boardSize, boardSize);
        this.setAlignment(Pos.CENTER);
        initializeTiles();
        this.setRotate(45);
        this.setScaleZ(-1);
    }

    private void initializeTiles() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                Tile tile = new Tile();
                tile.getPane().setTranslateX((col * tileSize) - (boardSize / 2 - tileSize / 2));
                tile.getPane().setTranslateY((row * tileSize) - (boardSize / 2 - tileSize / 2));
                this.getChildren().add(tile.getPane());
                board[row][col] = tile;

                Piece.PieceColor color = getPieceColor(row, col);
                Piece largePiece = new Piece(60, 60, 25, Piece.PieceSize.LARGE, color);
                tile.addPiece(largePiece);

                Piece smallPiece = new Piece(20, 20, 10, Piece.PieceSize.SMALL, color);
                tile.addPiece(smallPiece);

                if (isCorner(row, col)) {
                    Piece mediumPiece = new Piece(40, 40, 20, Piece.PieceSize.MEDIUM, getMediumPieceColor(row, col));
                    tile.addPiece(mediumPiece);
                }
            }
        }
    }

    private Piece.PieceColor getPieceColor(int row, int col) {
        if (isCorner(row, col)) {
            return Piece.PieceColor.YELLOW;
        } else {
            return Piece.PieceColor.BLUE;
        }
    }

    private boolean isCorner(int row, int col) {
        return (row == 0 && col == 0) || (row == 0 && col == 4) || (row == 4 && col == 0) || (row == 4 && col == 4);
    }

    private Piece.PieceColor getMediumPieceColor(int row, int col) {
        if (row == 0 && col == 0) return Piece.PieceColor.GREEN;
        if (row == 0 && col == 4) return Piece.PieceColor.RED;
        if (row == 4 && col == 0) return Piece.PieceColor.YELLOW;
        if (row == 4 && col == 4) return Piece.PieceColor.BLUE;
        return Piece.PieceColor.YELLOW; // Default, should never happen
    }
}
