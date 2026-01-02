package chapter7_linear.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    /*
        i != j
        i != k
        j != k
        target = 0
     */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        Arrays.sort(nums);

        int left;
        int right;
        int sum;

        for (int i = 0; i < nums.length - 2; i++) {
            // 중복된 값 건너뛰기
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // 간격을 좁혀가며 합 sum 계산
            left = i + 1;
            right = nums.length - 1;

            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 중복된 값 건너뛰기, 이 처리를 하지 않으면 같은 정답이 두 번 나올 수 있다.
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // 정답이 나왔으므로 투 포인터 모두 한 칸씩 이동
                    // 합이 0인 상황이므로 양 쪽 모두 이동해야 한다.
                    left++;
                    right--;
                }
            }
        }
        return results;
    }
}
