package chapter6_string.longest_palindromic_substring

var startPoint = 0
var maxLen = 0

fun longestPalindrome(s: String): String {
    // 문자 길이 저장
    val len = s.length

    // 길이가 1인 경우 예외 처리
    if (len < 2) return s

    // 우측으로 한 칸씩 이동하며 투 포인터 조사
    for (i in 0..<len - 1) {
        extendPalindrome(s, i, i + 1) // 2칸짜리 투 포인터
        extendPalindrome(s, i, i + 2) // 3칸짜리 투 포인터
    }

    // 왼쪽과 최대 길이만큼을 더한 오른쪽만큼의 문자를 정답으로 리턴
    return s.substring(startPoint, startPoint + maxLen)
}

private fun extendPalindrome(s: String, start: Int, end: Int) {
    // 투 포인터가 유효한 범위 내에 있고 양쪽 끝 문자가 일치하는 팰린드롬인 경우 범위 확장
    var start = start
    var end = end
    while (start >= 0 && end < s.length && s.get(start) == s.get(end)) {
        start--
        end++
    }

    // 기존 최대 길이보다 큰 경우 값 교체
    if (maxLen < end - start - 1) {
        startPoint = start + 1
        maxLen = end - start - 1
    }
}