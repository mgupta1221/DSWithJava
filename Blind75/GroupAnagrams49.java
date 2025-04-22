package Blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (map.containsKey(s)) {
                List<String> tempList = map.get(s);
                tempList.add(str);
                map.put(s, tempList);
            } else {
                List<String> tempList = new ArrayList<>();
                tempList.add(str);
                map.put(s, tempList);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (String k : map.keySet()) {
            List<String> subResult = new ArrayList<>();
            subResult.addAll(map.get(k));
            result.add(new ArrayList<>(subResult));
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

        List<List<String>> result = groupAnagrams(strs);
        for (List<String> list : result) {
            System.out.println(list);
        }
    }
}
