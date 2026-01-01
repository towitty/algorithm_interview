package chapter7_linear.trapping_rain_water

fun trap(height: IntArray): Int {
    var volume = 0
    var left = 0
    var right = height.size - 1
    var leftMax = 0
    var rightMax = 0

    while (left < right) {
        leftMax = height[left].coerceAtLeast(height[leftMax])
        rightMax = height[right].coerceAtLeast(height[rightMax])

        if (leftMax <= rightMax) {
            volume += leftMax - height[left]
            left++
        } else {
            volume += rightMax - height[right]
            right--
        }
    }

    return volume
}