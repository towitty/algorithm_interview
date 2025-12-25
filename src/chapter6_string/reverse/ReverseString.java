package chapter6_string.reverse;

public class ReverseString {

    public char[] reverseString(char[] str) {
        int start = 0;
        int end = str.length - 1;

        while (start < end)  {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;

            start++;
            end--;
        }

        return str;
    }
}
