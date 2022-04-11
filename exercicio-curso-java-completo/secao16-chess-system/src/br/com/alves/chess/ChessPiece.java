package br.com.alves.chess;

import br.com.alves.boardgame.Board;
import br.com.alves.boardgame.Piece;

public class ChessPiece extends Piece {
    private  Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
