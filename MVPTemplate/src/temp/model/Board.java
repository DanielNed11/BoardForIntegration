package temp.model;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;

public class Board extends StackPane {

    private final Tile[][] board = new Tile[5][5];

    public Board() {
        this.setMaxSize(200, 200); // Enforce exact size
        this.setAlignment(Pos.CENTER);
        initializeTiles();
        this.setRotate(45);
        this.setScaleZ(-1);
    }

    private void initializeTiles() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                Tile tile = new Tile();
                tile.getPane().setTranslateX((col * 40) - 80); // Center horizontally
                tile.getPane().setTranslateY((row * 40) - 80); // Center vertically
                this.getChildren().add(tile.getPane());
                board[row][col] = tile;

            }
        }
    }
}