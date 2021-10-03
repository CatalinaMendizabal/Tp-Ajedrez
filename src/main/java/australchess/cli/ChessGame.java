package australchess.cli;

import australchess.factory.*;
import australchess.piece.Move;
import australchess.piece.Piece;
import australchess.piece.PieceColor;
import lombok.Getter;

public class ChessGame {

    final BoardFactory boardFactory = new NormalBoardFactory();
    final PieceSetFactory pieceSetFactory = new DefaultPieceSetFactory();
    final Board board;
    final Player[] players = new Player[2];
    int currentPlaying = 0;
    final Piece[] whitePieceSet = pieceSetFactory.makePieceSet(PieceColor.WHITE);
    final Piece[] blackPieceSet = pieceSetFactory.makePieceSet(PieceColor.BLACK);

    public ChessGame(String whitePlayerId, String blackPlayerId) {
        players[0]  = new Player(whitePlayerId, PieceColor.WHITE, whitePieceSet);
        players[1] = new Player(blackPlayerId, PieceColor.BLACK, blackPieceSet);
        board = boardFactory.createBoard(whitePieceSet, blackPieceSet);
    }

    public Board getBoard() { return board; }

    public static boolean shouldContinue() {
        return true; //TODO Implement!
    }

    public Player getCurrentPlayer() { return players[currentPlaying]; }

    public void move(ParsedPosition from, ParsedPosition to) {
        Move movement;
        try {
            movement = new Move(from.boardLimitPosition(board), to.boardLimitPosition(board));
            board.movePiece(getCurrentPlayer().getColor(), movement);
            nextPlayer();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //TODO imlement check detection
    }

    private void nextPlayer() {
        currentPlaying ++;
        if (currentPlaying == players.length) currentPlaying = 0;
    }

    /*
    1. need to check player's turn
    2. need to check game status
    3. Board selection
     */
}
