package ru.kato.chess;

import java.util.HashSet;
import java.util.Set;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int startLine, int startColumn, int endLine, int endColumn) {
        if (!board.isThisChessPieceOnPoint(this, startLine, startColumn)) {
            return false;
        }

        if (Math.abs(endColumn - startColumn) > 1 && Math.abs(endLine - startColumn) > 1) {
            return false;
        }
        return !new King(this.color).isUnderAtack(board, endLine, endColumn);

    }

    public boolean isUnderAtack(ChessBoard board, int line, int column) {
        var enemyPices = board.getEnemyPieces(this.color);
        for (ChessPiece piece : enemyPices) {

            Position piecePosition = board.getPiecePosition(piece);
            if (piece.canMoveToPosition(board, piecePosition.getLine(), piecePosition.getColumn(), line, column)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
