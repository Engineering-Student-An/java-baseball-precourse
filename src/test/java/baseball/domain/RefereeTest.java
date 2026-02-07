package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    private Referee referee;

    @BeforeEach
    void setUp() {
        referee = new Referee();
    }

    @Test
    @DisplayName("3스트라이크: 모든 숫자와 위치가 일치하는 경우")
    void getResultTest3strike() {
        // given
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> player = Arrays.asList(1, 2, 3);

        // when
        Result result = referee.getResult(computer, player);

        // then
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("3볼: 숫자는 모두 같지만 위치가 다른 경우")
    void getResultTest3ball() {
        // given
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> player = Arrays.asList(2, 3, 1);

        // when
        Result result = referee.getResult(computer, player);

        // then
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(3);
    }

    @Test
    @DisplayName("낫싱: 일치하는 숫자가 하나도 없는 경우")
    void getResultTestNothing() {
        // given
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> player = Arrays.asList(4, 5, 6);

        // when
        Result result = referee.getResult(computer, player);

        // then
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("1스트라이크 1볼: 위치가 같은 수 1개, 위치는 다르지만 포함된 수 1개")
    void getResultTest1strike1ball() {
        // given
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> player = Arrays.asList(1, 3, 4); // 1(스트라이크), 3(볼), 4(낫싱)

        // when
        Result result = referee.getResult(computer, player);

        // then
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("2볼: 스트라이크 없이 볼만 2개인 경우")
    void getResultTest2ball() {
        // given
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> player = Arrays.asList(2, 1, 6); // 2(볼), 1(볼), 6(낫싱)

        // when
        Result result = referee.getResult(computer, player);

        // then
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(2);
    }
}
