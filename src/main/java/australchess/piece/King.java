package australchess.piece;

import australchess.cli.BoardPosition;

public class King extends Piece {

    public King(PieceColor color) {

        super(color, PieceType.KING);
        this.pieceId = 'K';

    }


    @Override
    public boolean isLegalMovement(Move move) {
        return false;
    }
}
