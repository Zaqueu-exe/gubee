package br.com.alves.chess.pieces;

import br.com.alves.boardgame.Board;
import br.com.alves.chess.ChessPiece;
import br.com.alves.chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "K";
    }

}
