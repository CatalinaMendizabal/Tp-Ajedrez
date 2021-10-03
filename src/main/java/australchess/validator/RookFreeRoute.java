package australchess.validator;

import australchess.cli.Board;
import australchess.piece.Move;

public class RookFreeRoute implements FreeRoute {
    @Override
    public boolean validate(Move move, Board board) {

        int maxNumber = move.getFrom().getNumber() > move.getTo().getNumber() ? move.getFrom().getNumber() : move.getTo().getNumber();
        int minNumber = move.getFrom().getNumber() > move.getTo().getNumber() ? move.getTo().getNumber() : move.getFrom().getNumber();
        int maxLetter = move.getFrom().getLetter() > move.getTo().getLetter() ? move.getFrom().getLetter() : move.getTo().getLetter();
        int minLetter = move.getFrom().getLetter() > move.getTo().getLetter() ? move.getTo().getLetter() : move.getFrom().getLetter();

        if(move.getFrom().getLetter().equals(move.getTo().getLetter())) {
            for (int i = minNumber + 1; i < maxNumber; i++) {
                if(board.getPosition(i, move.getTo().getLetter()).getPiece() != null) return false;
            }
        } else {
            for (int i = minLetter + 1; i < maxLetter; i++) {
                if(board.getPosition(move.getFrom().getNumber(), (char) i).getPiece() != null) return false;
            }
        }
        return true;
    }
}
