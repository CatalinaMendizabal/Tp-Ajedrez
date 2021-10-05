package australchess.factory;

import australchess.cli.Board;
import australchess.cli.BoardPosition;
import australchess.piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class NormalBoardFactory implements BoardFactory {

    @Override
    public Board createBoard(Piece[] whitePieceSet, Piece[] blackPieceSet) {
        List<BoardPosition> positions = new ArrayList<>(64);
        setPiecesOnBoard(whitePieceSet, positions, 'a', 'b');
        setPiecesOnBoard(blackPieceSet, positions,'h', 'g');

        for (char letter = 'c'; letter <= 'f'; letter++) {
            for (int number = 1; number <= 8; number++) {
                positions.add(new BoardPosition(null, number, letter));
            }
        }
        return new Board(positions);
    }

    private void setPiecesOnBoard(Piece[] colorPieceSet, List<BoardPosition> positions, Character row1, Character row2) {
        int i = 0;
        for (int number = 1; number <= 8; number++) {
            positions.add(new BoardPosition(colorPieceSet[i], number, row2));
            i++;
        }
        for (int number = 1; number <= 8; number++) {
            positions.add(new BoardPosition(colorPieceSet[i], number, row1));
            i++;
        }
    }
}
