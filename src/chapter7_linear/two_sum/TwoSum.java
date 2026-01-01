package chapter7_linear.two_sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new  HashMap<>();

        // 하나의 for 반복
        for (int i = 0; i < nums.length; i++) {
            // target에서 num을 뺀 값이 있으면 정답으로 리턴
            if (numsMap.containsKey(target - nums[i])) {
                return new int[]{numsMap.get(target - nums[i]), i};
            }
            // 정답이 아니므로 다음번 비교를 위해 인덱스를 맵에 저장
            numsMap.put(nums[i], i);
        }
        // 항상 정답이 존재해서 null은 호출되지 않음
        return null;
    }
}
