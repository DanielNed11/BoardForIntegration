package board.view;

import javafx.stage.Stage;

public class GamePresenter {

    private GameView gameView;
    private Stage stage;

    public GamePresenter(GameView gameView, Stage stage) {
        this.gameView = gameView;
        this.stage = stage;
    }
}
