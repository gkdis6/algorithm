import java.util.*;

class Solution {
  public int solution(String[] friends, String[] gifts) {
      int n = friends.length;

      Map<String, Integer> friendIndex = new HashMap<>();
      for (int i = 0; i < n; i++) {
          friendIndex.put(friends[i], i);
      }

      int[][] arr = new int[n][n];
      int[] giftScore = new int[n];

      for (String gift : gifts) {
          String[] parts = gift.split(" ");
          String sender = parts[0];
          String receiver = parts[1];

          int senderIdx = friendIndex.get(sender);
          int receiverIdx = friendIndex.get(receiver);

          arr[senderIdx][receiverIdx] += 1;
          arr[receiverIdx][senderIdx] -= 1;
          giftScore[senderIdx] += 1;
          giftScore[receiverIdx] -= 1;
      }

      int result = 0;
      for (int idx = 0; idx < n; idx++) {
          int score = giftScore[idx];
          int[] gift = arr[idx];

          int cur = 0;
          for (int i = 0; i < n; i++) {
              if (gift[i] > 0) {
                  cur++;
              } else if (gift[i] == 0 && score > giftScore[i]) {
                  cur++;
              }
          }

          result = Math.max(result, cur);
      }

      return result;
  }
}