package chapter7_linear.three_sum

fun threeSum(nums: IntArray): List<List<Int>> {
    var left = 0;
    var right = 0;
    var sum = 0;
    val results: MutableList<List<Int>> = mutableListOf()

    nums.sort()

    for (i in 0 until nums.size - 2) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }

        left = i + 1;
        right = nums.size - 1;
        while (left < right) {
            sum = nums[i] + nums[left] + nums[right]

            if (sum < 0) {
                left++
            } else if (sum > 0) {
                right--
            } else {
                results.add(listOf(nums[i], nums[left], nums[right]))

                while (left < right && nums[left] == nums[left + 1]) {
                    left++
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right--
                }

                left++
                right--
            }
        }
    }

    return results
}

fun refactorAIThreeSum(nums: IntArray): List<List<Int>> {
    val results = mutableListOf<List<Int>>()
    nums.sort()

    // 1. until 대신 0..nums.size - 3 범위를 사용하여 의도 명확화
    for (i in 0..nums.size - 3) {
        // 중복 요소 건너뛰기
        if (i > 0 && nums[i] == nums[i - 1]) continue

        var left = i + 1
        var right = nums.size - 1

        while (left < right) {
            val sum = nums[i] + nums[left] + nums[right]

            when {
                sum < 0 -> left++
                sum > 0 -> right--
                else -> {
                    results.add(listOf(nums[i], nums[left], nums[right]))

                    // 2. 중복 제거: 코틀린스럽게 left++를 사용하여 가독성 향상
                    while (left < right && nums[left] == nums[left + 1]) left++
                    while (left < right && nums[right] == nums[right - 1]) right--

                    left++
                    right--
                }
            }
        }
    }
    return results
}