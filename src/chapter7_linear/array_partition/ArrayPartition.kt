package chapter7_linear.array_partition

fun arrayPairSum(nums: IntArray): Int {
    var sum = 0
    nums.sort()
//     return nums.indices.step(2).sumOf { nums[it] }
    for (i in nums.indices step 2) {
        sum += nums[i]
    }

    return sum
}