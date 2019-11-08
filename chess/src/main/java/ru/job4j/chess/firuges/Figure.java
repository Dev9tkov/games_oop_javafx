package ru.job4j.chess.firuges;

public interface Figure {
    Cell position();

    /**
     * Массив с клетками, которые должна пройти фигура от клетки source до клетки dest
     */
    Cell[] way(Cell source, Cell dest);

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );
    }

    /**
     *  Объект класса с позицией dest. Каждый раз новая фигура
     */
    Figure copy(Cell dest);
}
