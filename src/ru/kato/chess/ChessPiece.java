package ru.kato.chess;

public abstract class ChessPiece {
    protected String color;
    protected Boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int endLine, int endColumn);

    public abstract String getSymbol();
}
