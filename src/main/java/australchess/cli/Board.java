package australchess.cli;

import australchess.piece.*;

import java.util.List;

public class Board {

    List<BoardPosition> positions;

    public Board(List<BoardPosition> positions) { this.positions = positions; }

    public List<BoardPosition> getPositions() { return positions; }

    public void movePiece(PieceColor color, Move move) {
        Piece pieceToMove = move.getFrom().getPiece();
        if (pieceToMove == null) throw new RuntimeException("No piece on selected position");
        if (!pieceToMove.getColor().equals(color)) throw new RuntimeException("Other player piece");
        if (!pieceToMove.isLegalMovement(move)) throw new RuntimeException("Illegal movement");
        if (!pieceToMove.isValidMove(move, this)) throw new RuntimeException("Invalid move");
        move.getFrom().setPiece(null);
        move.getTo().setPiece(pieceToMove);
       // if (pieceToMove.getPieceType() == PieceType.PAWN) ((Pawn) pieceToMove).setMoved(true);
    }

    public BoardPosition getPosition(Integer number, Character letter) {
        for (BoardPosition position : positions) {
            if (position.getNumber().equals(number) && position.getLetter().equals(letter)) return position;
        }
        return null;
    }
}
