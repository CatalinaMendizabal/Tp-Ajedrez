package australchess.validator;

import australchess.cli.Board;
import australchess.cli.BoardPosition;
import australchess.piece.Move;

import java.util.ArrayList;
import java.util.List;

public class MovementGenerator {

    public List<Move> generateMove(Board board, BoardPosition from) {
        List<Move> result = new ArrayList<>();
        for (BoardPosition position : board.getPositions()) {
            if (position.getPiece() != null && position.getPiece().getPieceId().equals('K')) continue;
            else if (position.getPiece() != null && position.getPiece().getPieceId().equals('k')) continue;
            result.add(new Move(from, position));
        }
        result.removeIf(move -> !board.validateMovement(move, from.getPiece().getColor()));
        return result;
    }
}
