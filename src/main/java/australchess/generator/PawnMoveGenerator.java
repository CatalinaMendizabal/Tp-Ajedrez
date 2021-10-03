package australchess.generator;

import australchess.cli.*;
import australchess.piece.*;
import australchess.validator.*;

import java.io.IOException;

public class PawnMoveGenerator implements MovementGenerator {
    ValidCapture validCapture = new ValidCapture();
    FreeRoute freeRoute = new PawnFreeRoute();

    @Override
    public Movement generateMove(Move move, Board board, PieceColor movingColor) throws IOException {
        BoardPosition from = move.getFrom();
        BoardPosition to = move.getTo();

        Movement movement = new Movement(from.getPiece(), to.getPiece(), move, GameStatus.ON_PROGRESS);
        boolean moved = ((Pawn) from.getPiece()).isMoved();

        if (movingColor.equals(PieceColor.WHITE)) {
            if (!((!moved && (to.getNumber() == from.getNumber() + 1 || to.getNumber() == from.getNumber() + 2) && to.getLetter() == from.getLetter())
                    || (!moved && (to.getNumber() == from.getNumber() + 1) && (to.getLetter() == from.getLetter() + 1 || to.getLetter() == from.getLetter() - 1) && to.getPiece() != null)
                    || (moved && to.getNumber() == from.getNumber() + 1 && to.getLetter() == from.getLetter())
                    || (moved && to.getNumber() == from.getNumber() + 1 && (to.getLetter() == from.getLetter() + 1 || to.getLetter() == from.getLetter() - 1) && to.getPiece() != null)
            )) throw new IOException("Illegal Pawn move");
        } else {
            if (!((!moved && (to.getNumber() == from.getNumber() - 1 || to.getNumber() == from.getNumber() - 2) && to.getLetter() == from.getLetter())
                    || (!moved && (to.getNumber() == from.getNumber() - 1) && (to.getLetter() == from.getLetter() + 1 || to.getLetter() == from.getLetter() - 1) && to.getPiece() != null)
                    || (moved && to.getNumber() == from.getNumber() - 1 && to.getLetter() == from.getLetter())
                    || (moved && to.getNumber() == from.getNumber() - 1 && (to.getLetter() == from.getLetter() + 1 || to.getLetter() == from.getLetter() - 1) && to.getPiece() != null)
            )) throw new IOException("Illegal Pawn move");
        }
        if (!freeRoute.validate(move, board)) throw new IOException("Route is not clear");
        ((Pawn) from.getPiece()).setMoved(true);
        return movement;
    }
}
