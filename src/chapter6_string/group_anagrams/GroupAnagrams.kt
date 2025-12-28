package chapter6_string.group_anagrams

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val results: MutableMap<String, MutableList<String>> = mutableMapOf()

    for (s in strs) {
        results.getOrPut(s.toCharArray().sorted().joinToString("")) {
            mutableListOf()
        }.add(s)
    }
    return ArrayList(results.values)
}

private fun refactorAIGroupAnagrams(strs: Array<String>): List<List<String>> {
    return strs.groupBy { s ->
        // charArray를 직접 정렬한 뒤 String으로 변환 (joinToString보다 빠름)
        val chars = s.toCharArray()
        chars.sort() // 원본(chars)을 정렬
        String(chars) // 정렬된 배열로 새 문자열 생성 (키 생성)
    }.values.toList()
}