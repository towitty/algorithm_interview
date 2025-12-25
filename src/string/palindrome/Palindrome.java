package string.palindrome;

public class Palindrome {

    public boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (!Character.isLetterOrDigit(str.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(str.charAt(end))) {
                end--;
            } else {
                if (Character.toLowerCase(str.charAt(start)) != Character.toLowerCase(str.charAt(end))) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    public boolean compareString(String s) {
        String filtered = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(filtered).reverse().toString();

        return filtered.equals(reversed);
    }
}
