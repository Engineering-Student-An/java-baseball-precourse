package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    @DisplayName("컴퓨터가 생성한 숫자의 개수는 정확히 3개여야 한다.")
    void generateNumberSizeTest() {
        // given
        Computer computer = new Computer();

        // when
        List<Integer> nums = computer.getNums();

        // then
        assertThat(nums).hasSize(3);
    }

    @Test
    @DisplayName("컴퓨터가 생성한 숫자는 모두 1부터 9 사이의 수여야 한다.")
    void generateNumberRangeTest() {
        // given
        Computer computer = new Computer();

        // when
        List<Integer> nums = computer.getNums();

        // then
        assertThat(nums).allMatch(number -> number >= 1 && number <= 9);
    }

    @Test
    @DisplayName("컴퓨터가 생성한 3개의 숫자는 서로 중복되지 않아야 한다.")
    void generateNumberDuplicateTest() {
        // given
        Computer computer = new Computer();

        // when
        List<Integer> nums = computer.getNums();

        // then
        assertThat(nums).doesNotHaveDuplicates();
    }

    // 여러 번 반복해서 안정성 검증위한 테스트
    @RepeatedTest(100)
    @DisplayName("반복 테스트: 100번 실행해도 항상 유효한 숫자가 생성되어야 한다.")
    void generateNumberConsistencyTest() {
        Computer computer = new Computer();
        List<Integer> nums = computer.getNums();

        assertThat(nums)
                .hasSize(3)
                .doesNotHaveDuplicates()
                .allMatch(number -> number >= 1 && number <= 9);
    }
}