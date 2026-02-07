package baseball.util;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    private Validator() {}
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String INVALID_INPUT = ERROR_PREFIX + "유효하지 않은 입력입니다.";
    private static final String INVALID_RESTART_INPUT = ERROR_PREFIX + "1, 2 중 입력하세요.";

    // 유효한 입력인지 검증
    public static ValidationResult validateGameNumber(String input) {
        if (validateIsNumber(input) && validateLength(input) && validateRange(input) && validateDuplicateNumber(input)) {
            return ValidationResult.ok();
        }

        return ValidationResult.fail(INVALID_INPUT);
    }

    // 유효한 게임 재시작 입력인지 검증
    public static ValidationResult validateRestartNumber(String input) {
        if (input.equals("1") || input.equals("2")) {
            return ValidationResult.ok();
        }

        return ValidationResult.fail(INVALID_RESTART_INPUT);
    }

    // 입력받은 숫자가 숫자가 아닌 값이 포함되어 있는지 검증
    static boolean validateIsNumber(String input) {
        if (!input.matches("^[0-9]*$")) return false;

        return true;
    }

    // 입력받은 숫자가 3자리가 맞는지 검증
    static boolean validateLength(String input) {
        if (input.length() != 3) return false;

        return true;
    }

    // 입력받은 숫자에 1~9 사이의 숫자가 존재하는 지 검증 (0을 포함하는 지)
    static boolean validateRange(String input) {
        if (input.contains("0")) return false;

        return true;
    }

    // 입력받은 숫자에 중복된 숫자가 있는지 검증
    static boolean validateDuplicateNumber(String input) {
        Set<Character> set = new HashSet<>();
        for (char num : input.toCharArray()) {
            if(set.contains(num)) return false;
            set.add(num);
        }

        return true;
    }
}
