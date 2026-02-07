package baseball.domain;

import java.util.List;

public class Referee {

    // 해당 라운드 결과 산출
    public Result getResult(List<Integer> computer, List<Integer> input) {
        int strike = countStrike(computer, input);
        int ball = countBall(computer, input);

        return new Result(strike, ball);
    }

    // 스트라이크 갯수 세기
    private int countStrike(List<Integer> computer, List<Integer> input) {
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(input.get(i))) strike ++;
        }

        return strike;
    }

    // 볼 갯수 세기
    private int countBall(List<Integer> computer, List<Integer> input) {
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if(!computer.get(i).equals(input.get(i)) && input.contains(computer.get(i))) ball ++;
        }

        return ball;
    }
}
