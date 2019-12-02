package job4j.tictactoe;

import java.lang.invoke.MethodType;
import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWin(Predicate<Figure3T> predicate) {
        boolean result = false;
        if (this.fillBy(predicate, 0, 0, 1, 0) ||//нижняя строка
                this.fillBy(predicate, 0, 0, 0, 1) ||//левый столбец
                this.fillBy(predicate, 0, 0, 1, 1) ||//диагональ с лева на право
                this.fillBy(predicate, this.table.length - 1, 0, -1, 1) ||//диагональ с права на лево
                this.fillBy(predicate, this.table.length - 1 , this.table.length - 1, -1, 0) ||//верхняя строка
                this.fillBy(predicate, 0 , (this.table.length - 1) / 2, 1, 0) ||//средняя строка
                this.fillBy(predicate, this.table.length - 1 , this.table.length - 1, 0, -1) ||//правый столбец
                this.fillBy(predicate, (this.table.length - 1) / 2 , 0, 0, 1)) {//средний столбец
            result = true;
        }
        return result;
    }

    public boolean isWinnerX() {
        return isWin(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return isWin(Figure3T::hasMarkO);
    }

    public boolean hasGap() {
        boolean result = false;
        for (int i = 0; i < table.length && !result; i++) {
            for (int j = 0; j < table.length; j++) {
                if (!table[i][j].hasMarkX() || !table[i][j].hasMarkO()) {
                    result = true;
                }
            }
        }
        return result;
    }
}
