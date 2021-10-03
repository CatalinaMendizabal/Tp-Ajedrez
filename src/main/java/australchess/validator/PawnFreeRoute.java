package australchess.validator;

import australchess.cli.Board;
import australchess.piece.Move;

public class PawnFreeRoute implements FreeRoute{
    @Override
    public boolean validate(Move move, Board board) {
        int dirY = move.getTo().getLetter() > move.getFrom().getLetter() ? 1 : -1;
        if(Math.abs(move.getFrom().getLetter() - move.getTo().getLetter()) == 2) {
            return board.getPosition(move.getFrom().getNumber(), (char) (move.getFrom().getLetter() + dirY)).getPiece() == null;
        }

        return true;
    }
}
