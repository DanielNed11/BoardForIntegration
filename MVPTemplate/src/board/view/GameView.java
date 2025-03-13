package board.view;

import board.model.Board;
import javafx.scene.layout.BorderPane;

public class GameView extends BorderPane {

    private Board board;

    public GameView() {
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        board = new Board();
    }

    private void layoutNodes() {
        setCenter(board);
    }

    Board getBoard() {
        return board;
    }
}
