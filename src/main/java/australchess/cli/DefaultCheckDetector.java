package australchess.cli;

public class DefaultCheckDetector implements CheckDetector {
    @Override
    public boolean validate(Board boar, String movingColor) {
        return false;
    }
}
