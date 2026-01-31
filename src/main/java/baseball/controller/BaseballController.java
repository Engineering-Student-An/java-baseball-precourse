package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Referee;
import baseball.util.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseballController {

    private final Referee referee;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballController() {
        this.referee = new Referee();
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
            List<Integer> inputNumbers = convertInputToList(input); // 입력을 List로 변환

            Map<String, Integer> result = referee.getResult(computer.getNums(), inputNumbers);  // 심판에게 결과 받음
            outputView.printResult(result.get("strike"), result.get("ball"));   // 받은 결과 출력

            // 3스트라이크 시 게임 승리
            if(result.get("strike") == 3 && result.get("ball") == 0) {
                outputView.printFinish();
                break;
            }
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

    // 재시작 입력 받기
    private boolean isRestart() {
        String input;
        do {
            input = inputView.inputRestartNumber();
        } while(!Validator.isRestartNumberPossible(input));

        if(input.equals("1")) return true;

        return false;
    }

    // 입력 String을 List<Integer>로 변환
    private List<Integer> convertInputToList(String input) {
        List<Integer> numbers = new ArrayList<>();

        for (char c : input.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }

        return numbers;
    }
}
