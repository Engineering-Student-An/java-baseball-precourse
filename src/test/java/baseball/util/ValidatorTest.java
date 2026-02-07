package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    private static final String INVALID_INPUT = "[ERROR] 유효하지 않은 입력입니다.";
    private static final String INVALID_RESTART_INPUT = "[ERROR] 1, 2 중 입력하세요.";

    @Test
    @DisplayName("게임 숫자 검증 성공: 1~9 사이의 서로 다른 3자리 숫자")
    void validateGameNumberTestSuccess() {
        assertThat(Validator.validateGameNumber("123").isValid()).isTrue();
        assertThat(Validator.validateGameNumber("987").isValid()).isTrue();
        assertThat(Validator.validateGameNumber("519").isValid()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1a3", "!!!", " "})
    @DisplayName("게임 숫자 검증 실패: 숫자가 아닌 값 포함")
    void validateGameNumberTestFailNotNumber(String input) {
        ValidationResult result = Validator.validateGameNumber(input);

        assertThat(result.isValid()).isFalse();
        assertThat(result.getMessage()).isEqualTo(INVALID_INPUT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12", "1234", "", "1"})
    @DisplayName("게임 숫자 검증 실패: 3자리가 아님")
    void validateGameNumberTestFailLength(String input) {
        ValidationResult result = Validator.validateGameNumber(input);

        assertThat(result.isValid()).isFalse();
        assertThat(result.getMessage()).isEqualTo(INVALID_INPUT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"102", "012", "000"})
    @DisplayName("게임 숫자 검증 실패: 0 포함")
    void validateGameNumberTestFailRange(String input) {
        ValidationResult result = Validator.validateGameNumber(input);

        assertThat(result.isValid()).isFalse();
        assertThat(result.getMessage()).isEqualTo(INVALID_INPUT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"112", "121", "222", "999"})
    @DisplayName("게임 숫자 검증 실패: 중복 숫자 포함")
    void validateGameNumberTestFailDuplicate(String input) {
        ValidationResult result = Validator.validateGameNumber(input);

        assertThat(result.isValid()).isFalse();
        assertThat(result.getMessage()).isEqualTo(INVALID_INPUT);
    }

    @Test
    @DisplayName("재시작 숫자 검증 성공: 1 또는 2")
    void validateRestartNumberTestSuccess() {
        assertThat(Validator.validateRestartNumber("1").isValid()).isTrue();
        assertThat(Validator.validateRestartNumber("2").isValid()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "3", "a", "!", "12", ""})
    @DisplayName("재시작 숫자 검증 실패: 1 또는 2 외의 값")
    void validateRestartNumberTestFail(String input) {
        ValidationResult result = Validator.validateRestartNumber(input);

        assertThat(result.isValid()).isFalse();
        assertThat(result.getMessage()).isEqualTo(INVALID_RESTART_INPUT);
    }
}
