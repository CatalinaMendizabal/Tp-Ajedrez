package australchess.detector;

import australchess.cli.Board;
import australchess.piece.PieceColor;

public interface CheckMateDetector {
    boolean isCheckMated(Board board, PieceColor movingColor);
}
