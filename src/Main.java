import baseball.BaseballFactory;
import baseball.BaseballGame;
import baseball.BaseballHistory;
import input.InputHelper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
        BaseballHistory baseballHistory = new BaseballHistory();
        boolean isRunning = true;

        while(isRunning) {
            System.out.println("0. 자리수 설정 1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기");

            String userInput = InputHelper.input("입력 : ");

            if (!isNumeric(userInput)) {
                System.out.println("올바른 숫자를 입력해주세요.");
                continue;
            }

            switch(Integer.parseInt(userInput)) {
                case 0 -> {
                    int size = Integer.parseInt(InputHelper.input("난이도 설정 : "));

                    if (size < 3 || size > 5) {
                        System.out.println("3 ~ 5 자리만 입력 가능합니다.");
                        continue;
                    }

                    BaseballGame baseballGame = BaseballFactory.generateWithSize(size);
                    baseballGame.play();
                    baseballHistory.record(baseballGame);
                }
                case 1 -> {
                    BaseballGame baseballGame = BaseballFactory.generate();
                    baseballGame.play();
                    baseballHistory.record(baseballGame);
                }
                case 2 -> baseballHistory.show();
                case 3 -> {
                    System.out.println("< 숫자 야구 게임을 종료합니다 >");
                    isRunning = false;
                }
                default -> System.out.println("올바른 숫자를 입력해주세요.");
            }
        }
    }

    private static boolean isNumeric(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
