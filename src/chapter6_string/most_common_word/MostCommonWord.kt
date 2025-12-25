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