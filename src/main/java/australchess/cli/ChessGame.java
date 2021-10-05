package australchess.cli;

import australchess.factory.*;
import australchess.piece.Move;
import australchess.piece.Piece;
import australchess.piece.PieceColor;

import java.util.List;

public class ChessGame {

    final BoardFactory boardFactory = new NormalBoardFactory();
    final PieceSetFactory pieceSetFactory = new DefaultPieceSetFactory();
    final Board board;
    static final Player[] players = new Player[2];
    static int currentPlaying = 0;
    final Piece[] whitePieceSet = pieceSetFactory.makePieceSet(PieceColor.WHITE);
    final Piece[] blackPieceSet = pieceSetFactory.makePieceSet(PieceColor.BLACK);
    public static CheckDetector checkDetector = new DefaultCheckDetector();

    public ChessGame(String whitePlayerId, String blackPlayerId) {
        players[0] = new Player(whitePlayerId, PieceColor.WHITE, whitePieceSet);
        players[1] = new Player(blackPlayerId, PieceColor.BLACK, blackPieceSet);
        board = boardFactory.createBoard(whitePieceSet, blackPieceSet);
    }

    public Board getBoard() {
        return board;
    }

    public boolean shouldContinue() {
        if (checkDetector.isChecked(board, getCurrentPlayer().getColor())) {
            boolean isCheckmated = true;
            List<BoardPosition> piecePositions = board.getColorPiecePosition(getCurrentPlayer().getColor());
            for (BoardPosition piecePosition : piecePositions) {
                if (piecePosition.getPiece().canMove(board, piecePosition)) {
                    isCheckmated = false;
                    break;
                }
            }
            if (isCheckmated) {
                System.out.printf("%s is checkmated!%n", getCurrentPlayer().getName());
                return false;
            }
            System.out.printf("%s is checked%n", getCurrentPlayer().getName());
        }
        return true;
    }

    public static Player getCurrentPlayer() {
        return players[currentPlaying];
    }

    public void move(ParsedPosition from, ParsedPosition to) {
        Move move;
        try {
            move = new Move(from.boardLimitPosition(board), to.boardLimitPosition(board));
            board.move(move, getCurrentPlayer().getColor());
            nextPlayer();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void nextPlayer() {
        currentPlaying++;
        if (currentPlaying == players.length) currentPlaying = 0;
    }

}
