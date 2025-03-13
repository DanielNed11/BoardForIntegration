package board3d.view;

import board3d.model.Board3D;

public class GamePresenter3D {
    private final Board3D model;
    private final GameView3D view;

    public GamePresenter3D(
            Board3D model, GameView3D view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {}
    private void updateView() {/* fills view*/}
}

