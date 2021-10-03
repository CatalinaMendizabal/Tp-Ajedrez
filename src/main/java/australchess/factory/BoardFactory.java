package australchess.factory;

import australchess.cli.Board;
import australchess.piece.Piece;

public interface BoardFactory {
    Board createBoard(Piece[] whitePieceSet, Piece[] blackPieceSet);
}
