import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BaseballGame {
    private int size = 3;
    private String inputValue;
    private String answer;
    private List<Character> availableChars = List.of('1', '2', '3', '4', '5', '6', '7', '8', '9');

    public BaseballGame() {
        this.answer = generateRandomWithShuffle();
    }

    public void play() {
        System.out.println("< 게임을 시작합니다 >");

        while(true) {
            Scanner sc = new Scanner(System.in);
            this.inputValue = sc.nextLine();

            int strikeCount = countStrike(inputValue, answer);

            if (strikeCount == this.size) {
                System.out.println(strikeCount + " 스트라이크! 정답입니다.");
                break;
            }

            int ballCount = countBall(inputValue, answer);

            if (strikeCount == 0 && ballCount == 0) {
                System.out.println("아웃");
            } else {
                System.out.println("스트라이크: " + strikeCount + " / " + "볼 : " + ballCount);
            }
        }
    }

    private String generateRandomWithShuffle() {
        List<Character> targets = new ArrayList<>(availableChars);

        Collections.shuffle(targets);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            result.append(targets.get(i));
        }

        return result.toString();
    }

    private int countStrike(String inputValue, String answer) {
        int count = 0;

        for (int i = 0; i < inputValue.length(); i++) {
            if (inputValue.charAt(i) == answer.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    private int countBall(String inputValue, String answer) {
        int count = 0;

        for (int i = 0; i < inputValue.length(); i++) {
            if (inputValue.charAt(i) != answer.charAt(i)
                    && answer.contains(Character.toString(inputValue.charAt(i)))
            ) {
                count++;
            }
        }

        return count;
    }
}