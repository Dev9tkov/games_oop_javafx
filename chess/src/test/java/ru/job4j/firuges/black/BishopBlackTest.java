package ru.job4j.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.Logic;

import ru.job4j.chess.exceptions.CellIsBusyException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class BishopBlackTest {
    @Test
    public void whenPosiyionC1() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell position = bishop.position();
        assertThat(position, is(Cell.C1));
    }

    @Test
    public void whenCopy() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Figure bishopcopy = bishop.copy(Cell.C1);
        assertThat(bishopcopy.position(), is(bishop.position()));
    }

    /**
     * Проверка метода way
     */
    @Test
    public void WhenNotIsDiagonal() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] way = bishop.way(Cell.C1, Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(way, is(expected));
    }

    /**
     * проверяем метод move
     */
    Logic logic = new Logic();

    @Test
    public void WhenFigureOnWay() {
        logic.add(new BishopBlack(Cell.C8));
        boolean result = logic.move(Cell.C8, Cell.F5);
        boolean expected = true;
        assertThat(result, is(expected));
    }


    /**
     * Проверяем, что если начальная и конечная точка - не диагональ
     * Упадет исключение
     * @throws IllegalStateException
     */
    @Test
    public void NotDiagonal() throws IllegalStateException {
        try {
            logic.add(new BishopBlack(Cell.C8));
            logic.move(Cell.C8, Cell.F6);
        } catch (IllegalStateException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    /**
     * Проверка, что если есть фигуры на пути движения - нельзя сдлеать ход
     * Для этого после создания слона добавим пешку на его пути движения
     * @throws IllegalStateException
     */
    @Test
    public void IfCellBusy() throws CellIsBusyException {
        try {
            logic.add(new BishopBlack(Cell.C8));
            logic.add(new PawnBlack(Cell.D7));
            logic.move(Cell.C8, Cell.F5);
        } catch (CellIsBusyException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }
}

