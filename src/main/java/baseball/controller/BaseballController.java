package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Referee;
import baseball.domain.Result;
import baseball.util.InputParser;
import baseball.util.ValidationResult;
import baseball.util.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {

    private final Referee referee;
    private final InputView inputView;
    private final OutputView outputView;
    private Computer computer;

    public BaseballController() {
        this.referee = new Referee();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

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
            List<Integer> inputNumbers = InputParser.parseToNumbers(input); // 입력을 List로 변환

            Result result = referee.getResult(computer.getNums(), inputNumbers);  // 심판에게 결과 받음
            outputView.printResult(result);   // 받은 결과 출력

            // 3스트라이크 시 게임 승리
            if (result.isWin()) {
                outputView.printFinish();
                break;
            }
        }
    }

    // 유효한 입력 받기
    private String getValidInput() {
        String input;
        while (true) {
            input = inputView.inputNumber();
            ValidationResult validationResult = Validator.validateGameNumber(input);
            if (validationResult.isValid()) {
                return input;
            }
            outputView.printError(validationResult.getMessage());
        }
    }

    // 재시작 입력 받기
    private boolean isRestart() {
        String input;
        while (true) {
            input = inputView.inputRestartNumber();
            ValidationResult validationResult = Validator.validateRestartNumber(input);
            if (validationResult.isValid()) {
                return input.equals("1");
            }
            outputView.printError(validationResult.getMessage());
        }
    }
}
