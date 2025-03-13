package board3d.view;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import board3d.model.Board3D;

public class GameView3D extends StackPane {

    private Board3D board;
    private VBox boardContainer;

    public GameView3D() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        board = new Board3D();
        boardContainer = new VBox();
        // create and configure controls
    }

    private void layoutNodes() {
        getChildren().add(board);
    }
}
