package Blind75.Arrays;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings271 {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("/").append(str);
        }
        return sb.toString();

    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0;
        List<String> decodedStrs = new ArrayList<>();
        while (i < s.length()) {
            int slash = s.indexOf("/", i);
            int strLen = Integer.parseInt(s.substring(i, slash));
            String str = s.substring(slash + 1, slash + 1 + strLen);
            decodedStrs.add(str);
            i = slash + strLen + 1;
        }
        return decodedStrs;
    }

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("Hello");
        strs.add("World");

        EncodeDecodeStrings271 codec = new EncodeDecodeStrings271();
        String encoded = codec.encode(strs);
        System.out.println("Encoded: " + encoded);
        List<String> decodedStrs = codec.decode(encoded);
        for (String str : decodedStrs) {
            System.out.println(str);
        }

    }
}
