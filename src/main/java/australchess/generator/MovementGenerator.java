package australchess.generator;

import australchess.cli.Board;
import australchess.piece.Move;
import australchess.piece.Movement;
import australchess.piece.PieceColor;

import java.io.IOException;

public interface MovementGenerator {
    Movement generateMove(Move move, Board board, PieceColor movingColor) throws IOException;
}
