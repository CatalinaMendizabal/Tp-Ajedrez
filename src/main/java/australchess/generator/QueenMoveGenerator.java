package australchess.generator;

import australchess.cli.Board;
import australchess.cli.BoardPosition;
import australchess.cli.GameStatus;
import australchess.piece.*;
import australchess.validator.*;

import java.io.IOException;
import java.util.Objects;

public class QueenMoveGenerator implements MovementGenerator {

    ValidCapture validCapture = new ValidCapture();
    FreeRoute rookFreeRoute = new RookFreeRoute();
    FreeRoute bishopFreeRoute = new BishopFreeRoute();

    @Override
    public Movement generateMove(Move move, Board board, PieceColor movingColor) throws IOException {
        BoardPosition from = move.getFrom();
        BoardPosition to = move.getTo();
        Movement movement = new Movement(from.getPiece(), to.getPiece(), move, GameStatus.ON_PROGRESS);

        if ((!rookFreeRoute.validate(move, board)) || (!bishopFreeRoute.validate(move, board))) throw new IOException("Route is not clear");

        if(!(((Math.abs(to.getLetter() - from.getLetter()) == Math.abs(to.getNumber() - from.getNumber()))) || ((Objects.equals(from.getNumber(), to.getNumber()) && !Objects.equals(from.getLetter(), to.getLetter())) ||
                (Objects.equals(from.getLetter(), to.getLetter()) && !Objects.equals(from.getNumber(), to.getNumber())))))
        throw new IOException("Illegal Queen move");

        return movement;
    }
}

