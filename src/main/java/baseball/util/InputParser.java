package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    private InputParser() {}

    public static List<Integer> parseToNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();

        for (char c : input.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }

        return numbers;
    }
}
