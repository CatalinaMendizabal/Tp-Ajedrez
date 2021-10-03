package australchess.cli;

import australchess.piece.Piece;


public class BoardPosition {
    private Piece piece;
    private final Integer number;
    private final Character letter;

    public BoardPosition(Piece piece, Integer number, Character letter) {
        this.piece = piece;
        this.number = number;
        this.letter = letter;
    }

    public Piece getPiece() {
        return piece;
    }

    public Integer getNumber() {
        return number;
    }

    public Character getLetter() {
        return letter;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

}
