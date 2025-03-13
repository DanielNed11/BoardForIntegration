package temp.model;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class Piece extends Box {

    private PhongMaterial material;
    private boolean isClicked = false;


    public Piece(double width, double height, double depth) {
        // Initialize the Box with specified dimensions
        super(width, height, depth); // e.g., 20x20x20

        // Set initial material (color)
        material = new PhongMaterial();
        material.setDiffuseColor(Color.BLUE); // Default color: blue
        material.setSpecularColor(Color.WHITE); // Add some shine
        this.setMaterial(material);

        // Position the box to sit on the tile
        this.setTranslateY(-height / 2); // Center of box base at tile surface
        this.setTranslateZ(-depth / 2);  // Adjust Z for 3D perspective

        this.setOnMouseClicked(event -> {
            if (!isClicked) {
                this.setColor(Color.RED);
                isClicked = true;
            } else {
                this.setColor(Color.BLUE);
                isClicked = false;
            }
        });
    }

    // Method to set the color of the box
    public void setColor(Color color) {
        if (material != null) {
            material.setDiffuseColor(color);
        }
    }

    // Method to highlight the piece
    public void highlight(boolean isHighlighted) {
        if (material != null) {
            if (isHighlighted) {
                material.setDiffuseColor(Color.RED); // Highlight color
            } else {
                material.setDiffuseColor(Color.BLUE); // Default color
            }
        }
    }

}