package australchess.validator;

import australchess.cli.Board;
import australchess.piece.Move;

public class CheckRule implements MovementValidator {
    @Override
    public boolean validate(Move move, Board board) {
        return false;
    } //TODO implement!

}
