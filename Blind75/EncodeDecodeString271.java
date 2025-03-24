package Blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString271 {

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("/").append(str);
        }
        return sb.toString();
    }

    // abc/4d cef 012345678

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        int len = s.length();
        int i = 0;
        List<String> result = new ArrayList<>();
        while (i < len) {
            int idx = s.indexOf("/", i);
            int slen = Integer.parseInt(s.substring(i, idx));

            String str = s.substring(idx + 1, idx + 1 + slen);
            i = idx + slen + 1;
            result.add(str);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("Hello", "World");
        System.out.println(encode(input));
        System.out.println(decode(encode(input)));
    }
}
