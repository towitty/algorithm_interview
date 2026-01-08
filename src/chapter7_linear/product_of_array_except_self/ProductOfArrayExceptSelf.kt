package chapter7_linear.product_of_array_except_self

fun productExceptSelf(nums: IntArray): IntArray {
    var p = 1
    val result = IntArray(nums.size)
    for (i in nums.indices) {
        result[i] = p
        p *= nums[i]
    }

    p = 1
    for (i in nums.indices.reversed()) {
        result[i] *= p
        p *= nums[i]
    }

    return result
}