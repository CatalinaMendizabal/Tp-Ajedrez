package australchess.piece;

import australchess.cli.Board;
import australchess.cli.BoardPosition;
import australchess.validator.MovementGenerator;
import australchess.validator.MovementValidator;

import java.util.List;

public class PieceMovementValidator {

    private final Piece piece;
    private final Coronation coronation = new QueenCoronation();

    public PieceMovementValidator(Piece piece) { this.piece = piece; }

    public void checkPieceMovement(Board board, Move move, PieceColor color) {
        if (piece == null) throw new RuntimeException("Empty position, choose another one");
        if (!piece.getColor().equals(color)) throw new RuntimeException("Can not move other player's pieces. Choose one piece of your set");
        if (piece.isValidMove(move)) throw new RuntimeException("That piece does not move like that");
        if (!validateMove(board, move)) throw new RuntimeException("Invalid movement");
    }

    public boolean validateMove(Board board, Move move) {
        List<MovementValidator> validators = piece.getValidators();
        for (MovementValidator validator : validators) {
            if (!validator.validate(move, board)) return false;
        }
        return true;
    }

    public boolean canMove(Board board, BoardPosition piecePosition) {
        MovementGenerator generator = piece.getGenerator();
        return !generator.generateMove(board, piecePosition).isEmpty();
    }

    public void setMoved(Move move, Board board) {
        if (piece.getPieceType() == PieceType.PAWN) {
            Pawn pawn = (Pawn) piece;
            pawn.setMoved(true);
            if (pawn.isAtEndOfBoard(board, move.getTo())) {
                Queen newQueen = (Queen) coronation.pieceCoronation(piece.getColor());
                move.getTo().setPiece(newQueen);
            }
        }
        else if (piece.getPieceType() == PieceType.ROOK) ((Rook) piece).setMoved(true);
        else if (piece.getPieceType() == PieceType.KING) ((King) piece).setMoved(true);
    }

}
