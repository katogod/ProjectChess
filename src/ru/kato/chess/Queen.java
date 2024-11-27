package ru.kato.chess;

import java.util.HashSet;
import java.util.Set;

public class Queen extends ChessPiece implements LineMovable, DiagonalMovable {
    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int endLine, int endColumn) {
        if (!chessBoard.isThisChessPieceOnPoint(this, startLine, startColumn)) {
            return false;
        }
        Set<Position> possiblePositions = new HashSet<>();
        possiblePositions.addAll(getLinePossiblePositions(chessBoard, startLine, startColumn, this.color));
        possiblePositions.addAll(getDiagonalPossiblePositions(chessBoard, startLine, startColumn, this.color));
        return possiblePositions.contains(new Position(endLine, endColumn));
    }

    @Override
    public String getSymbol() {
        return "Q";
    }

}
