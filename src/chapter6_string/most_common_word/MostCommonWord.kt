package chapter6_string.most_common_word

fun mostCommonWord(paragraph: String, banned: Array<String>): String {
    val counts = mutableMapOf<String, Int>();
    val words = paragraph.replace("\\W+".toRegex(), " ").lowercase().trim().split(" ")

    for (word in words) {
        if (!banned.contains(word)) {
            counts[word] = counts.getOrDefault(word, 0) + 1
            counts.getOrPut(word) { 0 }
        }
    }

    return counts.maxByOrNull { it.value }?.key ?: ""
}

fun refactorAIMostCommonWord(paragraph: String, banned: Array<String>): String {
    // 1. 검색 효율을 위해 banned를 Set으로 변환 (O(1) 검색)
    val bannedSet = banned.toSet()

    // 2. 단어 추출: 알파벳만 남기고 공백으로 분리
    // 시퀀스(asSequence)를 사용하면 중간 단계 리스트 생성을 최소화합니다.
    return paragraph.lowercase()
        .split(Regex("[^a-z]+")) // 알파벳이 아닌 모든 문자를 기준으로 분리
        .asSequence()
        .filter { it.isNotEmpty() && it !in bannedSet } // 공백 제외 및 banned 체크
        .groupingBy { it } // 그룹화
        .eachCount()       // 개수 세기 (Map<String, Int> 반환)
        .maxByOrNull { it.value } // 가장 빈도수 높은 항목 찾기
        ?.key ?: ""
}