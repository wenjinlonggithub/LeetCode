package note.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0);
    }
    public static boolean word_Break(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> dict = new ArrayList<>();
        dict.add("apple");
        dict.add("pen");
        boolean flag = wordBreak(s,dict);
        System.out.println(flag);
    }
}
