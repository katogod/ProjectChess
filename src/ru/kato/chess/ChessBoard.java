package ru.kato.chess;

import java.util.HashSet;
import java.util.Set;

public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8]; // creating a field for game
    String nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (checkPos(startLine) && checkPos(startColumn)) {

            if (!nowPlayer.equals(board[startLine][startColumn].getColor())) {
                return false;
            }

            if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
                board[endLine][endColumn] = board[startLine][startColumn]; // if piece can move, we moved a piece
                board[startLine][startColumn] = null; // set null to previous cell
                this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";

                return true;
            } else return false;
        } else {
            return false;
        }
    }

    public String getChessPieceColour(int line, int column) {
        return board[line][column] == null ? null : board[line][column].getColor();
    }

    public boolean isChessCellIsEmpty(int endLine, int endColumn) {
        return getChessPieceColour(endLine, endColumn) == null;
    }

    public boolean isChessPieceDifferentColor(int endLine, int endColumn, String color) {
        return isChessCellIsEmpty(endLine, endColumn) || !getChessPieceColour(endLine, endColumn).equals(color);
    }

    public Position getPiecePosition(ChessPiece piece) {
        for (int i = 7; i > -1; i--) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null && board[i][j] == piece) {
                    return new Position(i, j);
                }
            }

        }
        return null;
    }

    public boolean isThisChessPieceOnPoint(ChessPiece piece, int line, int column) {
        return board[line][column] == piece;
    }


    public void printBoard() {  //print board in console
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    public Set<ChessPiece> getEnemyPieces(String color) {
        Set<ChessPiece> enemies = new HashSet<>();
        for (int i = 7; i > -1; i--) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null && !board[i][j].getColor().equals(color)) {
                    enemies.add(board[i][j]);
                }
            }

        }
        return enemies;
    }

    public boolean castling0() {
        if (nowPlayer.equals("White")) {
            if (board[0][0] == null || board[0][4] == null) {
                return false;
            }
            if (board[0][0].getSymbol().equals("R") && board[0][4].getSymbol().equals("K") &&
                    board[0][1] == null && board[0][2] == null & board[0][3] == null) {
                if (board[0][0].getColor().equals("White") && board[0][4].getColor().equals("White") &&
                        board[0][0].check && board[0][4].check && !(new King("White").isUnderAtack(this, 0, 2))) {
                    board[0][4] = null;
                    board[0][2] = new King("White");
                    board[0][2].check = false;
                    board[0][0] = null;
                    board[0][3] = new Rook("White");
                    board[0][3].check = false;
                    nowPlayer = "Black";
                    return true;
                } else return false;
            } else return false;
        } else {
            if (board[7][0] == null || board[7][4] == null) {
                return false;
            }
            if (board[7][0].getSymbol().equals("R") && board[7][4].getSymbol().equals("K") &&
                    board[7][1] == null && board[7][2] == null & board[7][3] == null) {
                if (board[7][0].getColor().equals("Black") && board[7][4].getColor().equals("Black") &&
                        board[7][0].check && board[7][4].check && !(new King("Black").isUnderAtack(this, 7, 2))) {
                    board[7][4] = null;
                    board[7][2] = new King("Black");
                    board[7][2].check = false;
                    board[7][0] = null;
                    board[7][3] = new Rook("Black");
                    board[7][3].check = false;
                    nowPlayer = "White";
                    return true;
                } else return false;
            } else return false;
        }
    }

    public boolean castling7() {
        if (nowPlayer.equals("White")) {
            if (board[0][7] == null || board[0][4] == null) {
                return false;
            }
            if (board[0][7].getSymbol().equals("R") && board[0][4].getSymbol().equals("K") &&
                    board[0][6] == null && board[0][5] == null) {
                if (board[0][7].getColor().equals("White") && board[0][4].getColor().equals("White") &&
                        board[0][7].check && board[0][4].check && !(new King("White").isUnderAtack(this, 0, 6))) {
                    board[0][4] = null;
                    board[0][6] = new King("White");
                    board[0][6].check = false;
                    board[0][7] = null;
                    board[0][5] = new Rook("White");
                    board[0][5].check = false;
                    nowPlayer = "Black";
                    return true;
                } else return false;
            } else return false;
        } else {
            if (board[7][7] == null || board[7][4] == null) {
                return false;
            }
            if (board[7][7].getSymbol().equals("R") && board[7][4].getSymbol().equals("K") &&
                    board[7][6] == null && board[7][5] == null) {
                if (board[7][7].getColor().equals("Black") && board[7][4].getColor().equals("Black") &&
                        board[7][7].check && board[7][4].check && !(new King("Black").isUnderAtack(this, 7, 6))) {
                    board[7][4] = null;
                    board[7][6] = new King("Black");
                    board[7][6].check = false;
                    board[7][6] = null;
                    board[7][5] = new Rook("Black");
                    board[7][5].check = false;
                    nowPlayer = "White";
                    return true;
                } else return false;
            } else return false;
        }
    }
}