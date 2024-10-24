import java.util.ArrayList;
import java.util.List;

public class BaseballHistory {
    private final List<BaseballGame> histories = new ArrayList<>();

    public void record(BaseballGame baseballGame) {
        histories.add(baseballGame);
    }

    public void show() {
        for (int i = 0; i < histories.size(); i++) {
            System.out.println((i + 1) + " 번째 게임 : 시도 횟수 - " + histories.get(i).getResult());
        }
        System.out.println();
    }


}
