package australchess.cli;

public class ParsedPosition {
    private final Integer number;
    private final Character letter;

    public ParsedPosition(Integer number, Character letter) {
        this.number = number;
        this.letter = letter;
    }

    public Integer getNumber() { return number; }

    public Character getLetter() { return letter; }

    public BoardPosition toBoardPosition(Board board) {
        for (BoardPosition position : board.getPositions()) {
            if(position.getLetter().equals(this.getLetter()) && position.getNumber().equals(this.getNumber()))
                return position;
        }
        throw new RuntimeException("This position is not on the board");
    }
}
