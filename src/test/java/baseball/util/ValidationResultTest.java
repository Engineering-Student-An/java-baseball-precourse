package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationResultTest {

    @Test
    @DisplayName("ok()는 valid=true, message=''를 반환한다.")
    void isOkTeest() {
        ValidationResult result = ValidationResult.ok();

        assertThat(result.isValid()).isTrue();
        assertThat(result.getMessage()).isEmpty();
    }

    @Test
    @DisplayName("fail(message)는 valid=false, message를 보관한다.")
    void isFailTest() {
        ValidationResult result = ValidationResult.fail("[ERROR] 유효하지 않은 입력입니다.");

        assertThat(result.isValid()).isFalse();
        assertThat(result.getMessage()).isEqualTo("[ERROR] 유효하지 않은 입력입니다.");
    }
}
