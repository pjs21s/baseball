package baseball;

import input.InputHelper;

import java.util.*;

public class BaseballGame {
    private int size;
    private String inputValue;
    private String answer;
    private List<Character> availableChars = List.of('1', '2', '3', '4', '5', '6', '7', '8', '9');

    private int tryCount = 0;

    public BaseballGame(int size) {
        this.size = size;
        this.answer = generateRandomWithShuffle();
        System.out.println(this.answer);
    }

    public void play() {
        System.out.println("< 게임을 시작합니다 >");

        while(true) {
            this.inputValue = InputHelper.input("숫자를 입력하세요: ");

            if (!isValidInput(this.inputValue)) {
                System.out.println("올바르지 않은 입력값입니다. 다시 입력하세요.");
                continue;
            }

            this.tryCount++;

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

    public String getResult() {
        return "이 게임 시도 횟수 : " + this.tryCount;
    }

    private boolean isValidInput(String input) {
        Set<Character> usedChars = new HashSet<>();

        if (input == null || input.isEmpty()) {
            return false;
        }

        for (char c : input.toCharArray()) {
            if (!availableChars.contains(c)) {
                return false;
            }
            if (!usedChars.add(c)) {
                return false;
            }
        }
        return input.length() == this.size;
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