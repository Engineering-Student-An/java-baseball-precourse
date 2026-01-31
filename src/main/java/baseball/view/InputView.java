package baseball.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    // 숫자 입력
    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");

        return scanner.nextLine().trim();
    }

    // 재시작을 위한 입력
    public String inputRestartNumber() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 : ");

        return scanner.nextLine().trim();
    }
}
