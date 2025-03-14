package board.model;

public enum PieceSize {
    SMALL(20),
    MEDIUM(35),
    LARGE(50);

    private final int size;

    PieceSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
