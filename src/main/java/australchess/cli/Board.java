package australchess.cli;

import australchess.piece.*;
import australchess.validator.ValidCapture;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

public class Board {

    List<BoardPosition> positions;
    ValidCapture validCapture = new ValidCapture();

    public Board(List<BoardPosition> positions) { this.positions = positions; }

    public List<BoardPosition> getPositions() { return positions; }

    public Movement movePiece(PieceColor color, @NotNull Move move) throws IOException {
        Piece pieceToMove = move.getFrom().getPiece();
        if (pieceToMove == null) throw new IOException("No piece on selected position");
        if (pieceToMove.getColor().equals(color)) throw new IOException("Can not move other player piece");
        if (!validCapture.validate(move, this)) throw new IOException("Own pieces cannot be taken");

        move.getFrom().setPiece(null);
        move.getTo().setPiece(pieceToMove);
        return pieceToMove.getMovementGenerator().generateMove(move, this, pieceToMove.getColor());
    }

    public BoardPosition getPosition(Integer number, Character letter) {
        for (BoardPosition position : positions) {
            if (position.getNumber().equals(number) && position.getLetter().equals(letter)) return position;
        }
        return null;
    }
}
