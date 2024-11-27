package ru.kato.chess;

import java.util.HashSet;
import java.util.Set;

public interface LineMovable {
    default Set<Position> getLinePossiblePositions(ChessBoard board, int startLine, int startColumn, String colour) {
        Set<Position> posiblePositions = new HashSet<>();
        int pos = startLine + 1;
        while (pos <= 7) {
            if (board.isChessCellIsEmpty(pos, startColumn)) {
                posiblePositions.add(new Position(pos, startColumn));
            } else if (board.isChessPieceDifferentColor(pos, startColumn, colour)) {
                posiblePositions.add(new Position(pos, startColumn));
                break;
            }
            pos += 1;
        }
        pos = startColumn + 1;
        while (pos <= 7) {
            if (board.isChessCellIsEmpty(startLine, pos)) {
                posiblePositions.add(new Position(startLine, pos));
            } else if (board.isChessPieceDifferentColor(startLine, pos, colour)) {
                posiblePositions.add(new Position(startLine, pos));
                break;
            }
            pos += 1;
        }

        pos = startLine - 1;
        while (pos >= 0) {
            if (board.isChessCellIsEmpty(pos, startColumn)) {
                posiblePositions.add(new Position(pos, startColumn));
            } else if (board.isChessPieceDifferentColor(pos, startColumn, colour)) {
                posiblePositions.add(new Position(pos, startColumn));
                break;
            }
            pos -= 1;
        }
        pos = startColumn - 1;
        while (pos >= 0) {
            if (board.isChessCellIsEmpty(startLine, pos)) {
                posiblePositions.add(new Position(startLine, pos));
            } else if (board.isChessPieceDifferentColor(startLine, pos, colour)) {
                posiblePositions.add(new Position(startLine, pos));
                break;
            }
            pos -= 1;
        }
        return posiblePositions;
    }


}
