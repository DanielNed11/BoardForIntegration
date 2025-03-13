package board3d;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import board3d.model.Board3D;

public class Main3D extends Application {
    @Override
    public void start(Stage primaryStage) {
        Board3D board = new Board3D();

        Group group = new Group(board);

        Slider s = new Slider(0, 360, 0);
        s.setBlockIncrement(1);
        s.setTranslateY(250);
        group.rotateProperty().bind(s.valueProperty());

        Group root = new Group(group, s);
        root.setTranslateX(300);
        root.setTranslateY(300);
        Scene scene = new Scene(root, 600, 600, true);

        PerspectiveCamera camera = new PerspectiveCamera(false);
        camera.getTransforms().add(new Rotate(45, Rotate.X_AXIS));
        scene.setCamera(camera);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Blockade Game");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
