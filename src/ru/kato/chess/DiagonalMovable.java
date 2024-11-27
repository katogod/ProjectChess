package ru.kato.chess;

import java.util.HashSet;
import java.util.Set;

public interface DiagonalMovable {
    default Set<Position> getDiagonalPossiblePositions(ChessBoard board, int startLine, int startColumn, String colour) {
        Set<Position> posiblePositions = new HashSet<>();
        int line = startLine + 1;
        int column = startColumn + 1;
        while (line <= 7 && column <= 7) {
            if (board.isChessCellIsEmpty(line, column)) {
                posiblePositions.add(new Position(line, column));
            } else if (board.isChessPieceDifferentColor(line, column, colour)) {
                posiblePositions.add(new Position(line, column));
                break;
            }
            line += 1;
            column += 1;
        }
        line = startLine - 1;
        column = startColumn + 1;

        while (line >= 0 && column <= 7) {
            if (board.isChessCellIsEmpty(line, column)) {
                posiblePositions.add(new Position(line, column));
            } else if (board.isChessPieceDifferentColor(line, column, colour)) {
                posiblePositions.add(new Position(line, column));
                break;
            }
            line -= 1;
            column += 1;
        }

        line = startLine - 1;
        column = startColumn - 1;
        while (line >= 0 && column >= 0) {
            if (board.isChessCellIsEmpty(line, column)) {
                posiblePositions.add(new Position(line, column));
            } else if (board.isChessPieceDifferentColor(line, column, colour)) {
                posiblePositions.add(new Position(line, column));
                break;
            }
            line -= 1;
            column -= 1;
        }

        line = startLine - 1;
        column = startColumn + 1;
        while (line >= 0 && column <= 7) {
            if (board.isChessCellIsEmpty(line, column)) {
                posiblePositions.add(new Position(line, column));
            } else if (board.isChessPieceDifferentColor(line, column, colour)) {
                posiblePositions.add(new Position(line, column));
                break;
            }
            line -= 1;
            column += 1;
        }
        return posiblePositions;
    }
}
