import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
        BaseballHistory baseballHistory = new BaseballHistory();
        boolean isRunning = true;

        while(isRunning) {
            BaseballGame baseballGame = new BaseballGame();
            System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");

            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();

            if (!isNumeric(userInput)) {
                System.out.println("올바른 숫자를 입력해주세요.");
                continue;
            }

            switch(Integer.parseInt(userInput)) {
                case 1 -> {
                    baseballGame.play();
                    baseballHistory.record(baseballGame);
                }
                case 2 -> baseballHistory.show();
                case 3 -> {
                    System.out.println("< 숫자 야구 게임을 종료합니다 >");
                    isRunning = false;
                }
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
