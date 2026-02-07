package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputParserTest {

    @Test
    @DisplayName("문자열 입력을 List<Integer>로 변환한다.")
    void parseToNumbersTest() {
        List<Integer> result = InputParser.parseToNumbers("123");

        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("빈 문자열은 빈 리스트로 변환한다.")
    void parseToNumbersTestWhenEmpty() {
        List<Integer> result = InputParser.parseToNumbers("");

        assertThat(result).isEmpty();
    }
}
