package baseball.view;

public class OutputView {

    // 결과 출력
    public void printResult(int strike, int ball) {
        if(strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        System.out.println(buildResultString(strike, ball));
    }

    // 스트라이크와 볼 포함한 결과 String 빌드
    public String buildResultString(int strike, int ball) {
        StringBuilder stringBuilder = new StringBuilder();

        if(strike > 0) stringBuilder.append(strike).append("스트라이크 ");
        if(ball > 0) stringBuilder.append(ball).append("볼");

        return stringBuilder.toString().trim();
    }

    // 게임 종료 멘트 출력
    public void printFinish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }
}
