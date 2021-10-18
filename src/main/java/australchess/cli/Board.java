package australchess.cli;

import australchess.piece.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    List<BoardPosition> positions;

    public Board(List<BoardPosition> positions) {
        this.positions = positions;
    }

    public List<BoardPosition> getPositions() {
        return positions;
    }

    public BoardPosition getPosition(Integer number, Character letter) {
        for (BoardPosition position : positions) {
            if (position.getNumber().equals(number) && position.getLetter().equals(letter)) return position;
        }
        return null;
    }

    public List<BoardPosition> getPiecePositions(PieceColor color) {
        List<BoardPosition> result = new ArrayList<>(16);
        for (BoardPosition position : positions) {
            if (position.getPiece() != null) {
                if (position.getPiece().getColor().equals(color)) result.add(position);
            }
        }
        return result;
    }

    public boolean validateMovement(Move move, PieceColor color) {
        Piece pieceToMove = move.getFrom().getPiece();
        if (pieceToMove == null) return false;
        if (!pieceToMove.getColor().equals(color)) return false;
        if (pieceToMove.isValidMove(move)) return false;
        return (new PieceMovementValidator(pieceToMove).validateMove(this, move));
    }

    public void move(Move move, PieceColor color) {
        Piece pieceToMove = move.getFrom().getPiece();
        PieceMovementValidator pieceMovementValidator = new PieceMovementValidator(pieceToMove);
        pieceMovementValidator.checkPieceMovement(this, move, color);
        if (pieceToMove.getPieceType().equals(PieceType.KING) && ((King) pieceToMove).isCastling(move)) {
            if (castlePieces(move, (King) pieceToMove)) return;
            throw new RuntimeException("That movement is not valid");
        }
        move.getFrom().setPiece(null);
        move.getTo().setPiece(pieceToMove);
        pieceMovementValidator.setMoved(move, this);
    }

    private boolean castlePieces(Move move, King pieceToMove) {
        if (pieceToMove.canCastle(this, move)) {
            int dirX = move.getTo().getNumber() > move.getFrom().getNumber() ? 1 : -1;
            BoardPosition rookPosition = findCastlingRookPosition(move, dirX);

            move.getTo().setPiece(move.getFrom().getPiece());
            move.getFrom().setPiece(null);
            getPosition(move.getTo().getNumber() - dirX, move.getTo().getLetter()).setPiece(rookPosition.getPiece());
            rookPosition.setPiece(null);
            return true;
        }
        return false;
    }

    public BoardPosition findCastlingRookPosition(Move move, int dirX) {
        Character letter = move.getFrom().getLetter();
        PieceColor pieceColor = move.getFrom().getPiece().getColor();

        List<BoardPosition> rookPositions = getPiecePositions(pieceColor).stream().filter(e -> (e.getPiece().getPieceId() == 'R' || e.getPiece().getPieceId() == 'r')
                && e.getLetter() == letter).collect(Collectors.toList());

        if (dirX > 0)
            rookPositions = rookPositions.stream().filter(e -> e.getNumber() > move.getFrom().getNumber()).collect(Collectors.toList());
        else
            rookPositions = rookPositions.stream().filter(e -> e.getNumber() < move.getFrom().getNumber()).collect(Collectors.toList());
        if (rookPositions.isEmpty()) return null;
        return rookPositions.get(0);
    }

    public BoardPosition getKingPosition(PieceColor color) {
        BoardPosition boardPosition = null;
        for (BoardPosition position : positions) {
            if (position.getPiece() != null && position.getPiece().getColor().equals(color)) {
                if (position.getPiece().getPieceId().equals('K')) boardPosition = position;
                else if (position.getPiece().getPieceId().equals('k')) boardPosition = position;
            }
        }
        return boardPosition;
    }

}
