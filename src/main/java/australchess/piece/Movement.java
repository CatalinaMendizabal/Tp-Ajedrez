package australchess.piece;

import australchess.cli.GameStatus;

public class Movement {
    Piece movedPiece;
    Piece removedPiece;
    Move move;
   GameStatus gameStatus;

    public Movement(Piece movedPiece, Piece removedPiece, Move move, GameStatus gameStatus) {
        this.movedPiece = movedPiece;
        this.removedPiece = removedPiece;
        this.move = move;
        this.gameStatus = gameStatus;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
}
