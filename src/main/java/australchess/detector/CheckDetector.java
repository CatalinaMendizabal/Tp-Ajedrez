package australchess.detector;

import australchess.cli.Board;
import australchess.piece.PieceColor;

public interface CheckDetector {
    boolean isChecked(Board board, PieceColor movingColor);
}
