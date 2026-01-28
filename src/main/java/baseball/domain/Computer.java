package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {

    private final List<Integer> nums;
    private final Random random = new Random();

    public Computer() {
        this.nums = new ArrayList<>();
        generateNumbers();
    }

    private void generateNumbers() {
        while(nums.size() < 3) {
            Integer randomNumber = random.nextInt(9) + 1;

            if (!nums.contains(randomNumber)) {
                nums.add(randomNumber);
            }
        }
    }
}
