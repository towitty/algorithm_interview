package chapter7_linear.array_partition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayPartition {

    public int arrayPairSum(int[] nums) {
        int pointer = nums.length - 1;
        int result = 0;

        Arrays.sort(nums);

        while (pointer >= 0) {
            result += Math.min(nums[pointer], nums[pointer - 1]);
            pointer -= 2;
        }

        return result;
    }

    public int solution1(int[] nums) {
        int sum = 0;
        List<Integer> pair = new ArrayList<>();
        Arrays.sort(nums);

        for (int n : nums) {
            pair.add(n);
            if (pair.size() == 2) {
                sum += Collections.min(pair);
                pair.clear();
            }
        }
        return sum;
    }

    public int solution2(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sum += nums[i];
            }
        }
        return sum;
    }
}
