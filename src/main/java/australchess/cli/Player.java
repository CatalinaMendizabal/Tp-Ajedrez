package australchess.cli;

import australchess.piece.Piece;
import australchess.piece.PieceColor;

public class Player {
    private String name;
    PieceColor color;
    Piece[] pieceSet;

    public Player(String name, PieceColor color, Piece[] pieceSet) {
        this.name = name;
        this.color = color;
        this.pieceSet = pieceSet;
    }

    public String getName() {
        return name;
    }

    public PieceColor getColor() {
        return color;
    }

    public Piece[] getPieceSet() {
        return pieceSet;
    }
}

