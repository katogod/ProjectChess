package ru.kato.chess;

public class Rook extends ChessPiece implements LineMovable {
    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int startLine, int startColumn, int endLine, int endColumn) {
        if (!board.isThisChessPieceOnPoint(this, startLine, startColumn)) {
            return false;
        }

        return getLinePossiblePositions(board, startLine, startColumn, this.color).contains(new Position(endLine, endColumn));

    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
