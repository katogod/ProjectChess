package ru.kato.chess;

import java.util.HashSet;
import java.util.Set;

public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int endLine, int endColumn) {
        if (!chessBoard.isThisChessPieceOnPoint(this,startLine,startColumn)){
            return false;
        }
        Set<Position> posiblePositions = new HashSet<>();

        if (this.color.equals("White")) {
            if (startLine == 1 && chessBoard.isChessCellIsEmpty(endLine, endColumn)) {
                posiblePositions.add(new Position(startLine + 2, startColumn));
            }
            if (startLine + 1 <= 7 && chessBoard.isChessCellIsEmpty(endLine, endColumn)) {
                posiblePositions.add(new Position(startLine + 1, startColumn));
            }
            if ((startLine + 1) <= 7 && (startColumn + 1) <= 7 && chessBoard.isChessPieceDifferentColor(endLine, endColumn, this.color)) {
                posiblePositions.add(new Position(startLine + 1, startLine + 1));
            }
            if ((startLine + 1) <= 7 && (startColumn - 1) >= 0 && chessBoard.isChessPieceDifferentColor(endLine, endColumn, this.color)) {
                posiblePositions.add(new Position(startLine + 1, startLine - 1));
            }
        } else {
            if (startLine == 6 && chessBoard.isChessCellIsEmpty(endLine, endColumn)) {
                posiblePositions.add(new Position(startLine + -2, startColumn));
            }
            if (startLine - 1 >= 0 && chessBoard.isChessCellIsEmpty(endLine, endColumn)) {
                posiblePositions.add(new Position(startLine - 1, startColumn));
            }
            if ((startLine - 1) <= 7 && (startColumn + 1) <= 7 && chessBoard.isChessPieceDifferentColor(endLine, endColumn, this.color)) {
                posiblePositions.add(new Position(startLine - 1, startLine + 1));
            }
            if ((startLine - 1) >= 0 && (startColumn - 1) >= 0 && chessBoard.isChessPieceDifferentColor(endLine, endColumn, this.color)) {
                posiblePositions.add(new Position(startLine - 1, startLine - 1));
            }
        }

        return posiblePositions.contains(new Position(endLine, endColumn));
    }


    @Override
    public String getSymbol() {
        return "P";
    }

}
