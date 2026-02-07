package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    @DisplayName("strike/ball 값을 그대로 보관한다.")
    void getterTest() {
        Result result = new Result(2, 1);

        assertThat(result.getStrike()).isEqualTo(2);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("3스트라이크 0볼이면 승리다.")
    void isWinTest() {
        Result result = new Result(3, 0);

        assertThat(result.isWin()).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"2,0", "1,1", "0,0"})
    @DisplayName("승리 조건(3스트라이크 0볼)이 아니면 패배다.")
    void isNotWinTest(int strike, int ball) {
        Result result = new Result(strike, ball);

        assertThat(result.isWin()).isFalse();
    }
}
