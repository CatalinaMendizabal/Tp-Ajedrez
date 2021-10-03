package australchess.generator;

import australchess.cli.Board;
import australchess.cli.BoardPosition;
import australchess.cli.GameStatus;
import australchess.piece.King;
import australchess.piece.Move;
import australchess.piece.Movement;
import australchess.piece.PieceColor;
import australchess.validator.ValidCapture;

import java.io.IOException;

public class KingMoveGenerator implements MovementGenerator{
    @Override
    public Movement generateMove(Move move, Board board, PieceColor movingColor) throws IOException {
        ValidCapture validCapture = new ValidCapture();
        BoardPosition from = move.getFrom();
        BoardPosition to = move.getTo();

        Movement moveResult = new Movement(from.getPiece(), to.getPiece(), move, GameStatus.ON_PROGRESS);

        if(!(((Math.abs(to.getLetter() - from.getLetter()) * Math.abs(to.getNumber() - from.getNumber())) == 1) ||
                ((Math.abs(to.getLetter() - from.getLetter()) * Math.abs(to.getNumber() - from.getNumber())) == 0))) throw new IOException("Illegal King move");

        ((King) from.getPiece()).setMoved(true);
        return moveResult;
    }
}
