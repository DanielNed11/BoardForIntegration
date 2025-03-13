package board3d.model;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class Piece3D extends Box {
    public enum PieceSize { SMALL, MEDIUM, LARGE, BLOCKADE }
    public enum PieceColor { YELLOW, RED, GREEN, BLUE, BLACK }

    private PhongMaterial material;
    private boolean isClicked = false;
    private double depth;
    private PieceSize size;
    private PieceColor color;

    public Piece3D(double width, double height, double depth, PieceSize size, PieceColor color) {
        super(width, height, depth);
        this.depth = depth;
        this.size = size;
        this.color = color;

        material = new PhongMaterial();
        material.setDiffuseColor(mapColor(color));
        material.setSpecularColor(Color.WHITE);
        this.setMaterial(material);

        this.setOnMouseClicked(event -> {
            if (!isClicked) {
                this.setColor(Color.RED);
                isClicked = true;
            } else {
                this.setColor(mapColor(color));
                isClicked = false;
            }
        });
    }

    public void setColor(Color color) {
        if (material != null) {
            material.setDiffuseColor(color);
        }
    }

    public void highlight(boolean isHighlighted) {
        if (material != null) {
            if (isHighlighted) {
                material.setDiffuseColor(Color.RED);
            } else {
                material.setDiffuseColor(mapColor(color));
            }
        }
    }

    public double getPieceDepth() {
        return depth;
    }

    public PieceSize getSize() {
        return size;
    }

    public PieceColor getColor() {
        return color;
    }

    private Color mapColor(PieceColor color) {
        switch (color) {
            case YELLOW: return Color.YELLOW;
            case RED: return Color.RED;
            case GREEN: return Color.GREEN;
            case BLUE: return Color.BLUE;
            case BLACK: return Color.BLACK;
            default: return Color.GRAY;
        }
    }
}
