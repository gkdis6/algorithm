import java.util.*;

public class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> charToMinIndex = new HashMap<>();
        for (String line : keymap) {
            for (int idx = 0; idx < line.length(); idx++) {
                char c = line.charAt(idx);
                int position = idx + 1;
                charToMinIndex.put(c, Math.min(charToMinIndex.getOrDefault(c, Integer.MAX_VALUE), position));
            }
        }

        int[] result = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int cur = 0;
            for (char word : target.toCharArray()) {
                if (!charToMinIndex.containsKey(word)) {
                    cur = -1;
                    break;
                }
                cur += charToMinIndex.get(word);
            }
            result[i] = cur;
        }

        return result;
    }
}