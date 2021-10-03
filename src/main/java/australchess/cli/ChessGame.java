package australchess.cli;

import australchess.factory.*;
import australchess.piece.Move;
import australchess.piece.Movement;
import australchess.piece.Piece;
import australchess.piece.PieceColor;

public class ChessGame {

    final BoardFactory boardFactory = new NormalBoardFactory();
    final PieceSetFactory pieceSetFactory = new DefaultPieceSetFactory();
    final Board board;
    final Player[] players = new Player[2];
    int currentPlaying = 0;
    static GameStatus gameStatus;
    final Piece[] whitePieceSet = pieceSetFactory.makePieceSet(PieceColor.WHITE);
    final Piece[] blackPieceSet = pieceSetFactory.makePieceSet(PieceColor.BLACK);

    public ChessGame(String whitePlayerId, String blackPlayerId) {
        players[0]  = new Player(whitePlayerId, PieceColor.WHITE, whitePieceSet);
        players[1] = new Player(blackPlayerId, PieceColor.BLACK, blackPieceSet);
        board = boardFactory.createBoard(whitePieceSet, blackPieceSet);
        gameStatus = GameStatus.ON_PROGRESS;
    }

    public Board getBoard() { return board; }

    public static boolean shouldContinue() {
        return true; //TODO Implement!
    }

    public Player getCurrentPlayer() { return players[currentPlaying]; }

    public void move(ParsedPosition from, ParsedPosition to) {
        Move move;
        try {
            move = new Move(from.boardLimitPosition(board), to.boardLimitPosition(board));
            Movement movement = board.movePiece(getCurrentPlayer().getColor(), move);
            gameStatus = movement.getGameStatus();
            nextPlayer();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void nextPlayer() {
        if (!(gameStatus.equals(GameStatus.BLACK_IN_CHECK_MATED) || gameStatus.equals(GameStatus.WHITE_IN_CHECK_MATED))) {
            currentPlaying ++;
            if (currentPlaying == players.length) currentPlaying = 0;
        }
    }

    public Piece[] getWhitePieceSet() {
        return whitePieceSet;
    }

    public Piece[] getBlackPieceSet() {
        return blackPieceSet;
    }
}
