package ru.job4j.chess;

import ru.job4j.chess.exceptions.CellIsBusyException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;
import java.util.Optional;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    /**
     * Метод проверяет есть ли на пути фигуры другие фигуры при помощи @findby в каждой клетке
     * пути way. Если фигура есть-выдает ошибку
     */
    public boolean move(Cell source, Cell dest) throws CellIsBusyException {
        boolean rst = false;
        int index = this.findBy(source);
        int destination = this.findBy(dest);
        try {
            if (index != -1) {
                Cell[] steps = this.figures[index].way(source, dest);
                for (Cell step: steps) {
                    if (findBy(step) != -1 || destination != -1) {
                        throw new CellIsBusyException("This cell is busy");
                    }
                }
                if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                    rst = true;
                    this.figures[index] = this.figures[index].copy(dest);
                }
            }
        }
        catch (CellIsBusyException cie) {
            System.out.println(cie.getMessage());
        }
        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    @Override
    public String toString() {
        return "Logic{" +
                "figures=" + Arrays.toString(this.figures) +
                '}';
    }
}
