package board.model;

import javafx.scene.layout.BorderPane;

public class Board extends BorderPane {

    private Tile board;

    public Board() {
        board = new Tile();
        setCenter(board);
    }
}
