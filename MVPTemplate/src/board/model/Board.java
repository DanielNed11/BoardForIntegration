package board.model;

import javafx.scene.layout.GridPane;

public class Board extends GridPane {

    private static final int SIZE = 5; // Example: 8x8 board
    private static final int TILE_SIZE = 50;
    private final Tile[][] tiles = new Tile[SIZE][SIZE];


    public Board() {
        setVgap(2);
        setHgap(2);
        setMaxSize(SIZE * TILE_SIZE, SIZE * TILE_SIZE);

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                Tile tile = new Tile();
                tiles[row][col] = tile;

                add(tile, col, row);
            }
        }
        initializeBoard();
    }

    private void initializeBoard() {
        // BLUE
        // [4][4] - Small
        for (int i = 0; i < 5; i++) {
            addPiece(new Piece(PieceSize.MEDIUM, PieceColor.BLUE), 4,4);
        }
        // [0][1,2,3] - Large and small
        for (int i = 1; i <= 3; i++) {
            addPiece(new Piece(PieceSize.LARGE, PieceColor.BLUE), 0,i);
            addPiece(new Piece(PieceSize.SMALL, PieceColor.BLUE), 0,i);
        }
        // [1,2][3] - Large and small
        for (int i = 1; i <= 2; i++) {
            addPiece(new Piece(PieceSize.LARGE, PieceColor.BLUE), i,3);
            addPiece(new Piece(PieceSize.SMALL, PieceColor.BLUE), i,3);
        }

        // RED
        // [0][4] - Medium
        for (int i = 0; i < 5; i++) {
            addPiece(new Piece(PieceSize.MEDIUM, PieceColor.RED), 0,4);
        }
        // [1][0,1,2] - Large and small
        for (int i = 0; i <= 2; i++) {
            addPiece(new Piece(PieceSize.LARGE, PieceColor.RED), 1,i);
            addPiece(new Piece(PieceSize.SMALL, PieceColor.RED), 1,i);
        }
        // [2, 3][0] - Large and small
        for (int i = 2; i <= 3; i++) {
            addPiece(new Piece(PieceSize.LARGE, PieceColor.RED), i,0);
            addPiece(new Piece(PieceSize.SMALL, PieceColor.RED), i,0);
        }

        // YELLOW
        // [4][0] - Medium
        for (int i = 0; i < 5; i++) {
            addPiece(new Piece(PieceSize.MEDIUM, PieceColor.YELLOW), 4,0);
        }
        // [1,2,3][4] - Large and small
        for (int i = 1; i <= 3; i++) {
            addPiece(new Piece(PieceSize.LARGE, PieceColor.YELLOW), i,4);
            addPiece(new Piece(PieceSize.SMALL, PieceColor.YELLOW), i,4);
        }
        // [3][2, 3] - Large and small
        for (int i = 2; i <= 3; i++) {
            addPiece(new Piece(PieceSize.LARGE, PieceColor.YELLOW), 3,i);
            addPiece(new Piece(PieceSize.SMALL, PieceColor.YELLOW), 3,i);
        }
        // GREEN
        // [0][0] - Medium
        for (int i = 0; i < 5; i++) {
            addPiece(new Piece(PieceSize.MEDIUM, PieceColor.GREEN), 0,0);
        }
        // [2, 3, 4][1] - Large and small
        for (int i = 2; i <= 4; i++) {
            addPiece(new Piece(PieceSize.LARGE, PieceColor.GREEN), i,1);
            addPiece(new Piece(PieceSize.SMALL, PieceColor.GREEN), i,1);
        }
        // [4][2, 3] - Large and small
        for (int i = 2; i <= 3; i++) {
            addPiece(new Piece(PieceSize.LARGE, PieceColor.GREEN), 4,i);
            addPiece(new Piece(PieceSize.SMALL, PieceColor.GREEN), 4,i);
        }

    }

    public void addPiece(Piece piece, int row, int col) {
        tiles[row][col].addPiece(piece);
    }

    public int getSize(){
        return SIZE;
    }
}
