package board;

import board.view.GamePresenter;
import board.view.GameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GameView view = new GameView();
        new GamePresenter(view, primaryStage);

        Scene scene = new Scene(view, 600, 600);

        primaryStage.setTitle("Welcome");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {launch(args);}
}
