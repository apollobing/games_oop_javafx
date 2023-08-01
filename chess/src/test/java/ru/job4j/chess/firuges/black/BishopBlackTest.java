package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.job4j.chess.firuges.Cell.*;

class BishopBlackTest {
    @Test
    public void whenBishopBlackPositionIsF8() {
        BishopBlack bishopBlack = new BishopBlack(F8);
        assertThat(bishopBlack.position()).isEqualTo(F8);
    }

    @Test
    public void whenBishopBlackCopyIsD7() {
        BishopBlack bishopBlack = new BishopBlack(C8);
        assertThat(bishopBlack.copy(D7).position()).isEqualTo(D7);
    }

    @Test
    public void whenBishopBlackWayIsD2E3F4G5() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        assertThat(bishopBlack.way(G5)).isEqualTo(new Cell[]{D2, E3, F4, G5});
    }

    @Test
    public void whenBishopBlackIsDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        assertThat(bishopBlack.isDiagonal(C1, D2)).isTrue();
    }
}