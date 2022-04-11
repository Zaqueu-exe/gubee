package br.com.alves.chess.pieces;

import br.com.alves.boardgame.Board;
import br.com.alves.chess.ChessPiece;
import br.com.alves.chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "R";
    }
}
