package ru.kato.chess;

import java.util.HashSet;
import java.util.Set;

public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int endLine, int endColumn) {
        if (!chessBoard.isThisChessPieceOnPoint(this,startLine,startColumn)){
            return false;
        }
        Set<Position> posiblePositions = new HashSet<>();
        if ((startLine + 2) <= 7 && (startColumn + 1) <= 7) {
            posiblePositions.add(new Position(startLine + 2, startColumn + 1));
        }
        if ((startLine + 1) <= 7 && (startColumn + 2) <= 7) {
            posiblePositions.add(new Position(startLine + 1, startColumn + 2));
        }
        if ((startLine - 1) >= 0 && (startColumn + 2) <= 7) {
            posiblePositions.add(new Position(startLine - 1, startColumn + 2));
        }
        if ((startLine - 2) >= 0 && (startColumn + 1) <= 7) {
            posiblePositions.add(new Position(startLine - 2, startColumn + 1));
        }
        if ((startLine - 2) >= 0 && (startColumn - 1) >= 0) {
            posiblePositions.add(new Position(startLine - 2, startColumn - 1));
        }
        if ((startLine - 1) >= 0 && (startColumn - 2) >= 0) {
            posiblePositions.add(new Position(startLine - 1, startColumn - 2));
        }
        if ((startLine + 1) <= 7 && (startColumn - 2) >= 0) {
            posiblePositions.add(new Position(startLine + 1, startColumn - 2));
        }
        if ((startLine + 2) <= 7 && (startColumn - 1) >= 0) {
            posiblePositions.add(new Position(startLine + 2, startColumn - 1));
        }
        boolean empty = chessBoard.isChessCellIsEmpty(endLine, endColumn) || chessBoard.isChessPieceDifferentColor(endLine, endColumn, this.color);


        return posiblePositions.contains(new Position(endLine, endColumn)) && empty;

    }

    @Override
    public String getSymbol() {
        return "H";
    }

}
