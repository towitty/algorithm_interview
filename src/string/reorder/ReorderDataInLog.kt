package string.reorder

fun reorderLogFiles(logs: Array<String>): Array<String> {
    val digits = mutableListOf<String>()
    val letters = mutableListOf<String>()

    for (log in logs) {
        if (Character.isDigit(log.split(' ')[1][0]) ) {
            digits.add(log)
        } else {
            letters.add(log)
        }
    }

    letters.sortWith(Comparator { s1:String, s2: String ->
        val s1x = s1.split(" ", limit = 2)
        val s2x = s2.split(" ", limit = 2)

        val compared = s1x[1].compareTo(s2x[1])
        if (compared == 0) {
            s1x[0].compareTo(s2x[0])
        } else {
            compared
        }
    })

    letters.addAll(digits)
    return letters.toTypedArray()
}

fun refactorAIReorderLogFiles(logs: Array<String>):Array<String> {
    // 1. 별도의 리스트 생성 대신 partition을 사용하여 효율적으로 분리
    val (letterLogs, digitLogs) = logs.partition { log ->
        // log.split(' ')[1][0] 보다 인덱스를 직접 찾는 것이 더 빠릅니다.
        val firstSpaceIndex = log.indexOf(' ')
        log[firstSpaceIndex + 1].isDigit().not()
    }

    // 2. sortWith와 compareBy를 사용하여 가독성 극대화
    val sortedLetters = letterLogs.sortedWith(compareBy<String> { log ->
        // 정렬 기준 1: 식별자 뒤의 본문 내용
        log.substringAfter(' ')
    }.thenBy { log ->
        // 정렬 기준 2: 본문이 같을 경우 식별자지정된 비교자에 따라 정렬된 모든 요소의 목록을 반환합니다.
        // stable sort(모든 조건이 동일하면 원래의 상대적인 순서를 유지)
        log.substringBefore(' ')
    })

    // 3. 두 리스트 합쳐서 배열로 반환
    return (sortedLetters + digitLogs).toTypedArray()
}