package chapter7_linear.two_sum

fun twoSum(arr: Array<Int>, target: Int): IntArray {
    val numsMap = HashMap<Int, Int>()
    for ((i, num) in arr.withIndex()) {
        if (numsMap.containsKey(target - num)) {
            return intArrayOf(numsMap[target - num] ?: 0, i)
        }
        numsMap[num] = i
    }
    return intArrayOf(0, 0)
}