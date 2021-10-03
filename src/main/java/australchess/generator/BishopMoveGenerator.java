package australchess.generator;

import australchess.cli.Board;
import australchess.cli.GameStatus;
import australchess.piece.Move;
import australchess.piece.Movement;
import australchess.piece.PieceColor;
import australchess.validator.BishopFreeRoute;
import australchess.validator.FreeRoute;
import australchess.validator.ValidCapture;

import java.io.IOException;

public class BishopMoveGenerator implements MovementGenerator{

    FreeRoute freeRoute = new BishopFreeRoute();
    ValidCapture validCapture = new ValidCapture();

    @Override
    public Movement generateMove(Move move, Board board, PieceColor movingColor) throws IOException {
        Movement moveResult = new Movement(move.getFrom().getPiece(), move.getTo().getPiece(), move, GameStatus.ON_PROGRESS);

        if(!((Math.abs(move.getTo().getLetter() - move.getFrom().getLetter()) == Math.abs(move.getTo().getNumber() - move.getFrom().getNumber())))) throw new IOException("Illegal Bishop move");
        if(!freeRoute.validate(move, board)) throw new IOException("Route is not clear");
        return moveResult;
    }
}

