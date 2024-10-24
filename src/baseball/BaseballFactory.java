package baseball;

public class BaseballFactory {
    public static BaseballGame generate() {
        return generateWithSize(3);
    }

    public static BaseballGame generateWithSize(int size) {
        return new BaseballGame(size);
    }
}
