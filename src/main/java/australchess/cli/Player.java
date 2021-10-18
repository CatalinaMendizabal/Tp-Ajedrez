package australchess.cli;

import australchess.piece.PieceColor;

public class Player {
    private final String name;
    PieceColor color;

    public Player(PieceColor color, String name) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public PieceColor getColor() {
        return color;
    }
}

