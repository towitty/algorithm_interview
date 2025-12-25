package chapter6_string.reorder;

import java.util.ArrayList;

public class ReorderDataInLog {

    public static String[] reorderLogFiles(String[] logs) {
        // 식별 아이디 기억
        // 나머지 요소가 숫자인지 문자인지 구분
        // 문자 로그가 숫자 로그 보다 앞에 오도록 정렬
        // 문자가 동일한 경우 식별자순으로 정렬
        ArrayList<String> digitList = new ArrayList<>();
        ArrayList<String> letterList = new ArrayList<>();

        for (String s: logs) {
            String[] temp = s.split(" ");
            if (Character.isDigit(temp[1].charAt(0))) {
                digitList.add(s);
            } else {
                letterList.add(s);
            }
        }

        letterList.sort((o1, o2) -> {
            String[] s1x = o1.split(" ", 2);
            String[] s2x = o2.split(" ", 2);

            int compared = s1x[1].compareTo(s2x[1]);
            if (compared == 0) {
                return s1x[0].compareTo(s2x[0]);
            } else {
                return compared;
            }
        });

        letterList.addAll(digitList);
        return letterList.toArray(new String[0]);
    }
}
