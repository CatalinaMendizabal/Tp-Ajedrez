package australchess.validator;

import australchess.cli.Board;
import australchess.cli.BoardPosition;
import australchess.piece.Move;

import java.util.List;

public interface MovementGenerator {
    List<Move> generateMove(Board board, BoardPosition from);
}
