package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * Метод возвращает массив из клеток пути.
     * @param source начальная клетка
     * @param dest конечная клетка
     * @return
     */
    @Override
    public Cell[] way(Cell source, Cell dest) {
        try {
            if (!isDiagonal(source, dest)) {
                throw new IllegalStateException(
                        String.format("Could not way by diagonal from %s to %s", source, dest)
                );
            }
        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
        }
        int size = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[size];
        int deltaX;
        int deltaY;
        if (source.x > dest.x) {
            deltaX = -1;
        } else {
            deltaX = 1;
        }
        if (source.y > dest.y) {
            deltaY = -1;
        } else {
            deltaY = 1;
        }
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(source.x + (deltaX * (index + 1)) , source.y + (deltaY * (index + 1)));
        }
        return steps;
    }

    /**
     * Проверяет, является ли диагональю линия от начальной точки к конечной
     * @param source начальная клетка
     * @param dest конечная клетка
     * @return
     */
    public boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        int raznicax = Math.abs(dest.x - source.x);
        int raznicay = Math.abs(dest.y - source.y);
        if (raznicax == raznicay) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
