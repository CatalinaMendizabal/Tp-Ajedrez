package australchess.cli;

import australchess.piece.PieceColor;

public interface CheckDetector {
    boolean isChecked(Board boar, PieceColor movingColor);
}
