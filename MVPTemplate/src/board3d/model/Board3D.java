package board3d.model;

//import javafx.geometry.Pos;
//import javafx.scene.layout.StackPane;
//
//public class Board3D extends StackPane {
//
//    private final Tile3D[][] board = new Tile3D[5][5];
//    private final int tileSize = 70;
//    private final int boardSize = 350;
//
//    public Board3D() {
//        this.setMaxSize(boardSize, boardSize);
//        this.setAlignment(Pos.CENTER);
//        initializeTiles();
//        this.setRotate(45);
//        this.setScaleZ(-1);
//    }
//
//    private void initializeTiles() {
//        for (int row = 0; row < 5; row++) {
//            for (int col = 0; col < 5; col++) {
//                Tile3D tile = new Tile3D();
//                tile.getPane().setTranslateX((col * tileSize) - (boardSize / 2 - tileSize / 2));
//                tile.getPane().setTranslateY((row * tileSize) - (boardSize / 2 - tileSize / 2));
//                this.getChildren().add(tile.getPane());
//                board[row][col] = tile;
//
//                Piece3D.PieceColor color = getPieceColor(row, col);
//                Piece3D largePiece = new Piece3D(60, 60, 25, Piece3D.PieceSize.LARGE, color);
//                tile.addPiece(largePiece);
//
//                Piece3D smallPiece = new Piece3D(20, 20, 10, Piece3D.PieceSize.SMALL, color);
//                tile.addPiece(smallPiece);
//
//                if (isCorner(row, col)) {
//                    Piece3D mediumPiece = new Piece3D(40, 40, 20, Piece3D.PieceSize.MEDIUM, getMediumPieceColor(row, col));
//                    tile.addPiece(mediumPiece);
//                }
//            }
//        }
//    }
//
//    private Piece3D.PieceColor getPieceColor(int row, int col) {
//        if (isCorner(row, col)) {
//            return Piece3D.PieceColor.YELLOW;
//        } else {
//            return Piece3D.PieceColor.BLUE;
//        }
//    }
//
//    private boolean isCorner(int row, int col) {
//        return (row == 0 && col == 0) || (row == 0 && col == 4) || (row == 4 && col == 0) || (row == 4 && col == 4);
//    }
//
//    private Piece3D.PieceColor getMediumPieceColor(int row, int col) {
//        if (row == 0 && col == 0) return Piece3D.PieceColor.GREEN;
//        if (row == 0 && col == 4) return Piece3D.PieceColor.RED;
//        if (row == 4 && col == 0) return Piece3D.PieceColor.YELLOW;
//        if (row == 4 && col == 4) return Piece3D.PieceColor.BLUE;
//        return Piece3D.PieceColor.YELLOW; // Default, should never happen
//    }
//}

import board.model.PieceColor;
import board.model.PieceSize;
import javafx.scene.layout.GridPane;

public class Board3D extends GridPane {

    private static final int SIZE = 5; // Example: 8x8 board
    private static final int TILE_SIZE = 50;
    private final Tile3D[][] tiles = new Tile3D[SIZE][SIZE];


    public Board3D() {
        setVgap(2);
        setHgap(2);
        setMaxSize(SIZE * TILE_SIZE, SIZE * TILE_SIZE);

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                Tile3D tile = new Tile3D();
                tiles[row][col] = tile;

                add(tile, col, row);
            }
        }
        initializeBoard();
    }

    private void initializeBoard() {
        final int STACK_HEIGHT = -25;

        // BLUE
        // [4][4] - Medium (5 pieces stacked)
        for (int i = 0; i < 5; i++) {
            Piece3D piece = new Piece3D(PieceSize.MEDIUM, PieceColor.BLUE);
            piece.setTranslateZ(STACK_HEIGHT * i);
            addPiece(piece, 4, 4);
        }
        // [0][1,2,3] - Large and Small
        for (int i = 1; i <= 3; i++) {
            Piece3D largePiece = new Piece3D(PieceSize.LARGE, PieceColor.BLUE);
            largePiece.setTranslateZ(0); // Base level
            addPiece(largePiece, 0, i);
            Piece3D smallPiece = new Piece3D(PieceSize.SMALL, PieceColor.BLUE);
            smallPiece.setTranslateZ(STACK_HEIGHT); // Stacked above large
            addPiece(smallPiece, 0, i);
        }
        // [1,2][3] - Large and Small
        for (int i = 1; i <= 2; i++) {
            Piece3D largePiece = new Piece3D(PieceSize.LARGE, PieceColor.BLUE);
            largePiece.setTranslateZ(0);
            addPiece(largePiece, i, 3);
            Piece3D smallPiece = new Piece3D(PieceSize.SMALL, PieceColor.BLUE);
            smallPiece.setTranslateZ(STACK_HEIGHT);
            addPiece(smallPiece, i, 3);
        }

        // RED
        // [0][4] - Medium (5 pieces stacked)
        for (int i = 0; i < 5; i++) {
            Piece3D piece = new Piece3D(PieceSize.MEDIUM, PieceColor.RED);
            piece.setTranslateZ(STACK_HEIGHT * i);
            addPiece(piece, 0, 4);
        }
        // [1][0,1,2] - Large and Small
        for (int i = 0; i <= 2; i++) {
            Piece3D largePiece = new Piece3D(PieceSize.LARGE, PieceColor.RED);
            largePiece.setTranslateZ(0);
            addPiece(largePiece, 1, i);
            Piece3D smallPiece = new Piece3D(PieceSize.SMALL, PieceColor.RED);
            smallPiece.setTranslateZ(STACK_HEIGHT);
            addPiece(smallPiece, 1, i);
        }
        // [2,3][0] - Large and Small
        for (int i = 2; i <= 3; i++) {
            Piece3D largePiece = new Piece3D(PieceSize.LARGE, PieceColor.RED);
            largePiece.setTranslateZ(0);
            addPiece(largePiece, i, 0);
            Piece3D smallPiece = new Piece3D(PieceSize.SMALL, PieceColor.RED);
            smallPiece.setTranslateZ(STACK_HEIGHT);
            addPiece(smallPiece, i, 0);
        }

        // YELLOW
        // [4][0] - Medium (5 pieces stacked)
        for (int i = 0; i < 5; i++) {
            Piece3D piece = new Piece3D(PieceSize.MEDIUM, PieceColor.YELLOW);
            piece.setTranslateZ(STACK_HEIGHT * i);
            addPiece(piece, 4, 0);
        }
        // [1,2,3][4] - Large and Small
        for (int i = 1; i <= 3; i++) {
            Piece3D largePiece = new Piece3D(PieceSize.LARGE, PieceColor.YELLOW);
            largePiece.setTranslateZ(0);
            addPiece(largePiece, i, 4);
            Piece3D smallPiece = new Piece3D(PieceSize.SMALL, PieceColor.YELLOW);
            smallPiece.setTranslateZ(STACK_HEIGHT);
            addPiece(smallPiece, i, 4);
        }
        // [3][2,3] - Large and Small
        for (int i = 2; i <= 3; i++) {
            Piece3D largePiece = new Piece3D(PieceSize.LARGE, PieceColor.YELLOW);
            largePiece.setTranslateZ(0);
            addPiece(largePiece, 3, i);
            Piece3D smallPiece = new Piece3D(PieceSize.SMALL, PieceColor.YELLOW);
            smallPiece.setTranslateZ(STACK_HEIGHT);
            addPiece(smallPiece, 3, i);
        }

        // GREEN
        // [0][0] - Medium (5 pieces stacked)
        for (int i = 0; i < 5; i++) {
            Piece3D piece = new Piece3D(PieceSize.MEDIUM, PieceColor.GREEN);
            piece.setTranslateZ(STACK_HEIGHT * i);
            addPiece(piece, 0, 0);
        }
        // [2,3,4][1] - Large and Small
        for (int i = 2; i <= 4; i++) {
            Piece3D largePiece = new Piece3D(PieceSize.LARGE, PieceColor.GREEN);
            largePiece.setTranslateZ(0);
            addPiece(largePiece, i, 1);
            Piece3D smallPiece = new Piece3D(PieceSize.SMALL, PieceColor.GREEN);
            smallPiece.setTranslateZ(STACK_HEIGHT);
            addPiece(smallPiece, i, 1);
        }
        // [4][2,3] - Large and Small
        for (int i = 2; i <= 3; i++) {
            Piece3D largePiece = new Piece3D(PieceSize.LARGE, PieceColor.GREEN);
            largePiece.setTranslateZ(0);
            addPiece(largePiece, 4, i);
            Piece3D smallPiece = new Piece3D(PieceSize.SMALL, PieceColor.GREEN);
            smallPiece.setTranslateZ(STACK_HEIGHT);
            addPiece(smallPiece, 4, i);
        }
    }

    public void addPiece(Piece3D piece, int row, int col) {
        tiles[row][col].addPiece(piece);
    }

    public int getSize(){
        return SIZE;
    }
}

