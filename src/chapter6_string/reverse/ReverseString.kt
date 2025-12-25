package chapter6_string.reverse

fun reverseString(s: CharArray): String {
//    var start = 0
//    var end = s.size - 1
//
//    while (start < end) {
//        s[start] = s[end].also { s[end] = s[start] }
//        start++
//        end--
//    }

    /* reverse logic

    val midPoint = (size / 2) - 1
    if (midPoint < 0) return
    var reverseIndex = lastIndex
    for (index in 0..midPoint) {
        val tmp = this[index]
        this[index] = this[reverseIndex]
        this[reverseIndex] = tmp
        reverseIndex--
    }
     */
    return s.reverse().toString()

}