package australchess.piece;

import australchess.cli.BoardPosition;

public class Move {
    BoardPosition from;
    BoardPosition to;

    public Move(BoardPosition from, BoardPosition to) {
        this.from = from;
        this.to = to;
    }

    public BoardPosition getFrom() { return from; }

    public BoardPosition getTo() { return to; }
}
