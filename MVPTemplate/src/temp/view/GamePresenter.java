package temp.view;

import temp.model.Board;

public class GamePresenter {
    private final Board model;
    private final  GameView view;

    public GamePresenter(
            Board model, GameView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {}
    private void updateView() {/* fills view*/}
}

