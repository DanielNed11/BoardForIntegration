package board.view;

import board.model.Board;
import board.model.Piece;
import board.model.PieceSize;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.Random;

public class GameView extends BorderPane {

    private Board board;
    private Random rand = new Random();

    public GameView() {
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        board = new Board();

    }

    private void layoutNodes() {
        StackPane contentPane = new StackPane(board);
        contentPane.setAlignment(Pos.CENTER);

        setCenter(contentPane); // Ensure the center contains the StackPane
    }

    public Board getBoard() {
        return board;
    }
}
