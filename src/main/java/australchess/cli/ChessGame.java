package australchess.cli;

import australchess.detector.CheckMateDetector;
import australchess.detector.DefaultCheckMateDetector;
import australchess.detector.CheckDetector;
import australchess.detector.DefaultCheckDetector;
import australchess.factory.*;
import australchess.piece.Move;
import australchess.piece.Piece;
import australchess.piece.PieceColor;

public class ChessGame {
    private static GameStatus gameStatus;
    final BoardFactory boardFactory = new NormalBoardFactory();
    final PieceSetFactory pieceSetFactory = new DefaultPieceSetFactory();
    final Board board;
    final Player[] players = new Player[2];
    int currentPlayerIndex = 0;
    public static CheckDetector checkDetector = new DefaultCheckDetector();
    public static CheckMateDetector checkMateDetector = new DefaultCheckMateDetector();

    public ChessGame(String whitePlayer, String blackPlayer) {
        board = boardFactory.createBoard(pieceSetFactory.createPieceSet(PieceColor.WHITE), pieceSetFactory.createPieceSet(PieceColor.BLACK));
        players[0] = new Player(PieceColor.WHITE, whitePlayer);
        players[1] = new Player(PieceColor.BLACK, blackPlayer);
        gameStatus = GameStatus.PLAYING;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    private PieceColor getCurrentPlayerColor() { return getCurrentPlayer().getColor(); }

    public Board getBoard() { return board; }

    public static GameStatus getGameStatus() { return gameStatus; }

    private void nextPlayer() {
        currentPlayerIndex++;
        if (currentPlayerIndex == players.length) currentPlayerIndex = 0;
    }

    public boolean shouldContinue() {
        if (checkDetector.isChecked(board, getCurrentPlayerColor())) {
            gameStatus = GameStatus.PLAYER_CHECKED;

            boolean checkmated = checkMateDetector.isCheckMated(board, getCurrentPlayerColor());
            if (checkmated) gameStatus = GameStatus.PLAYER_CHECKMATED;
        }
        return gameStatus.equals(GameStatus.PLAYING) || gameStatus.equals(GameStatus.PLAYER_CHECKED);
    }

    public void move(ParsedPosition from, ParsedPosition to) {
        Move movement;
        try {
            movement = new Move(from.toBoardPosition(board), to.toBoardPosition(board));
            board.move(movement, getCurrentPlayerColor());
            nextPlayer();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
