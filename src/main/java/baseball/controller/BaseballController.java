package baseball.controller;

import baseball.domain.Computer;
import baseball.util.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    private final InputView inputView;
    private final OutputView outputView;

    public BaseballController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    private static Computer computer;

    // 프로그램 실행
    public void run() {
        do {
            play();
        } while(isRestart());
    }

    // 게임 시작
    private void play() {
        computer = new Computer(); // 상대(컴퓨터)가 랜덤 숫자 생성

        while (true) {
            String input = getValidInput(); // 입력 받기


            // TODO : 스트라이크/볼 판별
        }
    }

    // 유효한 입력 받기
    private String getValidInput() {
        String input;
        do {
            input = inputView.inputNumber();
        } while(!Validator.isGameNumberPossible(input));

        return input;
    }

    private boolean isRestart() {
        String input;
        do {
            input = inputView.inputRestartNumber();
        } while(!Validator.isRestartNumberPossible(input));

        System.out.println("true");
        if(input.equals("1")) return true;

        return false;
    }
}
