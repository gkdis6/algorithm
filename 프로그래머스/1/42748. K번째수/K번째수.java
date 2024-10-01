import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i<commands.length; i++){
            int[] cl = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(cl);
            answer[i] = cl[commands[i][2]-1];
        }
        return answer;
    }
}