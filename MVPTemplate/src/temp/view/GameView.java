package temp.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import temp.model.Board;

public class GameView extends StackPane {

    private Board board;
    private VBox boardContainer;

    public GameView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        board = new Board();
        boardContainer = new VBox();
        // create and configure controls
    }

    private void layoutNodes() {
        getChildren().add(board);
    }
}
