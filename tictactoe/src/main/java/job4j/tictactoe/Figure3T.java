package job4j.tictactoe;

import javafx.scene.shape.Rectangle;

public class Figure3T extends Rectangle {
    private boolean markX = false;
    private boolean markO = false;

    public Figure3T() {
    }

    public Figure3T(boolean markX, boolean markO) {
        this.markX = markX;
        this.markO = markO;
    }

    public void take(boolean markX) {
            this.markX = markX;
            this.markO = !markX;
    }

    /**
     * Имеет ли клетка X
     * @return
     */
    public boolean hasMarkX() {
        return this.markX;
    }

    /**
     * Имеет ли клетка O
     * @return
     */
    public boolean hasMarkO() {
        return this.markO;
    }
}
