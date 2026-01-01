package chapter7_linear.trapping_rain_water;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater {
    /*
        n 은 height 배열의 길이
        height 배열의 원소는 최소 1개부터 최대 2만개 까지 있으므로 O(n^2)으로 풀면 안됨
     */

    public int trapSolution1(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length - 1;
        int volume = 0;

        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            // 더 높은 쪽을 향해 투 포인터 이동
            if (leftMax <= rightMax) {
                // 왼쪽 막대 최대 높이와의 차이를 더하고 왼쪽 포인터 이동
                volume += leftMax - height[left];
                left += 1;
            } else {
                // 오른쪽 막대 최대 높이와의 차이를 더하고 오른쪽 포인터 이동
                volume += rightMax - height[right];
                right -= 1;
            }
        }

        return volume;
    }

    public int trapSolution2(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int volume = 0;

        for (int i = 0; i < height.length; i++) {
            // 변곡점을 만나는 경우
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 스택에서 꺼낸다.
                Integer top = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                // 스택의 마지막 위치까지를 거리로 계산
                int distance = i - stack.peek() - 1;
                // 현재 높이 또는 스택의 마지막 위치 높이 중 낮은 값에 방금 꺼낸 높이의 차이를 물 높이로 지정
                int waters = Math.min(height[i], height[stack.peek()]) - height[top];

                // 물이 쌓이는 양은 거리와 물 높이의 곱
                volume += distance * waters;
            }

            // 진행하면서 현재 위치를 스택에 삽입
            stack.push(i);
        }

        return volume;
    }
}
