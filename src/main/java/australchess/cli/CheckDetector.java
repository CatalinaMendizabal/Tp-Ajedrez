package australchess.cli;

public interface CheckDetector {
    boolean validate(Board boar, String movingColor);
}
