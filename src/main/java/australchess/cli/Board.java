package australchess.cli;

import australchess.piece.*;
import australchess.validator.ValidCapture;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Board {

    List<BoardPosition> positions;
    ValidCapture validCapture = new ValidCapture();

    public Board(List<BoardPosition> positions) {
        this.positions = positions;
    }

    public List<BoardPosition> getPositions() {
        return positions;
    }

    public void move(Move move, PieceColor color) throws IOException {
        Piece pieceToMove = move.getFrom().getPiece();
        if (pieceToMove == null) throw new IOException("There is no piece on the chosen position.");
        if (!validCapture.validate(move, this)) throw new IOException("Own pieces cannot be taken");
        if (!pieceToMove.getColor().equals(color)) throw new IOException("That piece is not of your color.");
        if (!pieceToMove.isValidMove(move)) throw new IOException("That piece does not move like that.");
        if (!pieceToMove.validateMove(this, move)) throw new IOException("That move is not valid!");

        if (pieceToMove.getPieceType() == PieceType.ROOK) ((Rook) pieceToMove).setMoved(true);
        if (pieceToMove.getPieceType() == PieceType.KING) ((King) pieceToMove).setMoved(true);

        move.getFrom().setPiece(null);
        move.getTo().setPiece(pieceToMove);


        if (pieceToMove.getPieceType() == PieceType.PAWN) {
            Pawn pawn = (Pawn) pieceToMove;
            pawn.setMoved(true);
            if (pawn.reachedBoardEnd(this, move.getTo())) {
                move.getTo().setPiece(new Queen(color));
            }
        }

    }

    public boolean isValidMovement(Move move, PieceColor color) {
        Piece pieceToMove = move.getFrom().getPiece();
        if(pieceToMove == null) return false;
        if(!pieceToMove.getColor().equals(color)) return false;
        if(!pieceToMove.isValidMove(move)) return false;
        return pieceToMove.validateMove(this, move);
    }

    public BoardPosition getPosition(Integer number, Character letter) {
        for (BoardPosition position : positions) {
            if (position.getNumber().equals(number) && position.getLetter().equals(letter)) return position;
        }
        return null;
    }

    public BoardPosition getKingPosition(PieceColor color) {
        for (BoardPosition position : positions) {
            if (position.getPiece() != null) {
                if (position.getPiece().getPieceId().equals('K') && position.getPiece().getColor().equals(color))
                    return position;
            }
        }
        throw new RuntimeException(String.format("There is no %s king on the board.", color));
    }

    public List<BoardPosition> getColorPiecePosition(PieceColor color) {
        List<BoardPosition> result = new ArrayList<>(16);
        for (BoardPosition position : positions) {
            if(position.getPiece() != null) {
                if(position.getPiece().getColor().equals(color)) result.add(position);
            }
        }
        return result;
    }
}
