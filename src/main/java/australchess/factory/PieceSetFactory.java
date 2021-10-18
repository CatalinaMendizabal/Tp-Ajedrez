package australchess.factory;

import australchess.piece.Piece;
import australchess.piece.PieceColor;

public interface PieceSetFactory {
    Piece[] createPieceSet(PieceColor color);
}
