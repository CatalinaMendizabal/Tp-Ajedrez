package australchess.cli;
import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;
import java.util.Scanner;

// Starter CLI interface for the chess game, modify as you wish.
// TODO: Fill in!
public class App {

    final static BoardPrinter boardPrinter = new DefaultBoardPrinter();
    private static ChessGame chessGame;

    public static void main(String[] args) throws IOException {

        printHeader();
        final var whitePlayerId = askForString("Name of player that moves white: ");
        final var blackPlayerId = askForString("Name of player that moves black: ");
        chessGame = new ChessGame(whitePlayerId, blackPlayerId);
        System.out.println();
        System.out.println();

        while (ChessGame.shouldContinue()) {
            printCurrentPlayerTurn();
            System.out.println();
            printBoard();
            final var positionFrom = askForPosition("Enter position of the piece you want to move");
            final var positionTo = askForPosition("Enter position of cell you want to move it to");
            chessGame.move(positionFrom, positionTo);
            System.out.println();
            System.out.println();
        }
    }

    private static void printBoard() {
        var boardAsString = boardPrinter.print(chessGame.getBoard().getPositions());
        System.out.println(boardAsString);
    }

    public static Player playerToMove() { return chessGame.getCurrentPlayer(); }

    public static void printCurrentPlayerTurn() {
        System.out.println("It's " + playerToMove().getColor() + " player turn!");
    }

    private static ParsedPosition askForPosition(String question) {
        System.out.println(question);
        System.out.print("Enter in format -> (number,letter): ");
        var scanner = new Scanner(System.in);
        var positionAsString = scanner.nextLine();
        return ParsedPositionParser.parse(positionAsString)
                .orElseGet(() -> askForPosition("The position " + positionAsString + " is invalid. Please enter a new one"));
    }

    private static String askForString(String question) {
        System.out.println(question);
        var scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void printHeader() throws IOException {
        String header = FigletFont.convertOneLine("AustralChess");
        System.out.println(header);
    }
}
