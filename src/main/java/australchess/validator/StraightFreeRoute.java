package australchess.validator;

import australchess.cli.Board;
import australchess.cli.BoardPosition;
import australchess.piece.Move;

public class StraightFreeRoute implements MovementValidator {

    @Override
    public boolean validate(Move move, Board board) {
        BoardPosition from = move.getFrom();
        BoardPosition to = move.getTo();

        int offX = to.getNumber() - from.getNumber();
        int offY = to.getLetter() - from.getLetter();
        if (offX != 0 && offY != 0) return false;

        int maxNumber = from.getNumber() > to.getNumber() ? from.getNumber() : to.getNumber();
        int minNumber = from.getNumber() > to.getNumber() ? to.getNumber() : from.getNumber();
        int maxLetter = from.getLetter() > to.getLetter() ? from.getLetter() : to.getLetter();
        int minLetter = from.getLetter() > to.getLetter() ? to.getLetter() : from.getLetter();

        if (from.getLetter().equals(to.getLetter())) {
            for (int i = minNumber + 1; i < maxNumber; i++) {
                if (board.getPosition(i, to.getLetter()).getPiece() != null) return false;
            }
        } else {
            for (int i = minLetter + 1; i < maxLetter; i++) {
                if (board.getPosition(from.getNumber(), (char) i).getPiece() != null) return false;
            }
        }
        return true;
    }
}
