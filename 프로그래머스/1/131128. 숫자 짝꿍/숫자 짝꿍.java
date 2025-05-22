import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];

        for (char digitChar : X.toCharArray()) {
            countX[digitChar - '0']++;
        }

        for (char digitChar : Y.toCharArray()) {
            countY[digitChar - '0']++;
        }

        StringBuilder partnerBuilder = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            int commonOccurrences = Math.min(countX[i], countY[i]);
            for (int j = 0; j < commonOccurrences; j++) {
                partnerBuilder.append(i);
            }
        }

        String result = partnerBuilder.toString();

        if (result.isEmpty()) {
            return "-1";
        } else if (result.charAt(0) == '0') {
            return "0";
        } else {
            return result;
        }
    }
}