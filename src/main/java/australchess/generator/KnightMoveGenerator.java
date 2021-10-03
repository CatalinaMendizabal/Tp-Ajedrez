package australchess.generator;

import australchess.cli.Board;
import australchess.cli.BoardPosition;
import australchess.cli.GameStatus;
import australchess.piece.*;
import australchess.validator.ValidCapture;

import java.io.IOException;

public class KnightMoveGenerator implements MovementGenerator{

    ValidCapture validCapture = new ValidCapture();

    @Override
    public Movement generateMove(Move move, Board board, PieceColor movingColor) throws IOException {
        BoardPosition from = move.getFrom();
        BoardPosition to = move.getTo();
        Movement movement = new Movement(from.getPiece(), to.getPiece(), move, GameStatus.ON_PROGRESS);

        if(!((Math.abs(to.getLetter() - from.getLetter()) * Math.abs(to.getNumber() - from.getNumber())) == 2)) throw new IOException("Illegal Knight move");

        return movement;
    }
}
