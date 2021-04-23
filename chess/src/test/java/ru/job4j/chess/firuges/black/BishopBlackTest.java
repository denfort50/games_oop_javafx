package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B1);
        assertThat(bishopBlack.position(), is(Cell.B1));
    }

    @Test
    public void copy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B1);
        assertThat(bishopBlack.copy(Cell.E4).position(), is(Cell.E4));
    }

    @Test
    public void way() {
        BishopBlack bishopBlack1 = new BishopBlack(Cell.C1);
        Cell[] cells1 = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(bishopBlack1.way(Cell.G5), is(cells1));

        BishopBlack bishopBlack2 = new BishopBlack(Cell.H3);
        Cell[] cells2 = new Cell[] {Cell.G2, Cell.F1};
        assertThat(bishopBlack2.way(Cell.F1), is(cells2));

        BishopBlack bishopBlack3 = new BishopBlack(Cell.G1);
        Cell[] cells3 = new Cell[] {Cell.F2, Cell.E3, Cell.D4, Cell.C5};
        assertThat(bishopBlack3.way(Cell.C5), is(cells3));

        BishopBlack bishopBlack4 = new BishopBlack(Cell.C7);
        Cell[] cells4 = new Cell[] {Cell.D6, Cell.E5, Cell.F4, Cell.G3};
        assertThat(bishopBlack4.way(Cell.G3), is(cells4));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void wrongWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.C2);
    }
}