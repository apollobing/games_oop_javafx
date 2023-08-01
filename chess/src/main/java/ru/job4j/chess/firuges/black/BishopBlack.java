package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int x = position.getX();
        int y = position.getY();
        int deltaX = 1;
        int deltaY = 1;
        for (int index = 0; index < size; index++) {
            if (position.getX() < dest.getX()) {
                x = x + deltaX;
                y = y - deltaY;
            } else {
                x = x - deltaX;
                y = y + deltaY;
            }
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return source.getX() != dest.getX() && source.getY() != dest.getY()
                && Math.abs(dest.getX() - source.getX()) == Math.abs(dest.getY() - source.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
