package AdobeQues;

//https://practice.geeksforgeeks.org/problems/reverse-each-word-in-a-given-string1001/1

public class ReverseWordsInString {
    static String reverseWords(String S) {
        int start = 0;
        int end;
        char ch[] = S.toCharArray(); // converting to char array for swapping charcters
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '.') {
                end = i - 1;
                while (start < end) {
                    char temp = ch[start];
                    ch[start] = ch[end];
                    ch[end] = temp;
                    start++;
                    end--;
                }
                start = i + 1;
            }
            // Now when we reach end of string - we have to swap last elements from last '.'
            // till the last character
            if (i == S.length() - 1) {
                end = i;
                while (start < end) {
                    char temp = ch[start];
                    ch[start] = ch[end];
                    ch[end] = temp;
                    start++;
                    end--;
                }
            }
        }

        // returning character array (with swapped characters) - as String result
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        String S = "i.like.this.program.very.much";
        String result = reverseWords(S);
        System.out.println(result);
    }

}
