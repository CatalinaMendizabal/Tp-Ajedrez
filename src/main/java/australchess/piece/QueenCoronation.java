package australchess.piece;

public class QueenCoronation implements Coronation{

    @Override
    public Piece pieceCoronation(PieceColor pieceColor) {
        return new Queen(pieceColor);
    }
}
