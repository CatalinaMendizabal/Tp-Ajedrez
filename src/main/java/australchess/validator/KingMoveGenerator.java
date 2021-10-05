package australchess.validator;

import australchess.cli.Board;
import australchess.cli.BoardPosition;
import australchess.piece.Move;

import java.util.ArrayList;
import java.util.List;

public class KingMoveGenerator implements MovementGenerator {
    @Override
    public List<Move> generateMove(Board board, BoardPosition from) {
        List<Move> result = new ArrayList<>();
        for (BoardPosition position : board.getPositions()) {
            if (position.getPiece() != null && position.getPiece().getPieceId().equals('K')) continue;
            result.add(new Move(from, position));
        }
        result.removeIf(movement -> !board.isValidMovement(movement, from.getPiece().getColor()));
        return result;
    }
}
