package temp;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import temp.model.Board;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Board board = new Board();

        Group group = new Group(board);

        Slider s = new Slider(0,360, 0);
        s.setBlockIncrement(1);
        s.setTranslateY(200);
        group.rotateProperty().bind(s.valueProperty());


        Group root = new Group(group,s);
        root.setTranslateX(200);
        root.setTranslateY(200);
        Scene scene = new Scene(root, 500, 500, true);

        // Center the Board manually in the Group (since Group doesn’t center)
        PerspectiveCamera camera = new PerspectiveCamera(false);

        camera.getTransforms().add(new Rotate(45, Rotate.X_AXIS));

        scene.setCamera(camera);
        primaryStage.setScene(scene);
        primaryStage.setTitle("3D Box Board Test");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}