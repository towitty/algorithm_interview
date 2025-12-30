package algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JavaAlgorithm {

    // 이진 탐색
    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // DFS(재귀)
    // 트리, 그래프, 백트래킹의 뼈대
    public void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next, graph, visited);
            }
        }
    }

    // BFS
    // 최단 거리, 레벨 탐색
    public void bfs(int start, List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }

    // 투 포인터
    // 정렬된 배열, 구간 문제
    public void twoPointer(int[] arr, int target) {
        int left = 0;
        int right = arr.length -1;

        while (left < right) {
            int sum =  arr[left] + arr[right];

            if (sum == target) {
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }

    // 슬라이딩 윈도우
    public void slidingWindowFix(int[] arr) {
        int windowSum = 0;
        int maxSum = 0;
        int k = 3;

        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];

            if (i >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[i - (k - 1)];
            }
        }
    }

    public void slidingWindow(int[] arr, int target) {
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= arr[left];
                left++;
            }
        }
    }
}
