import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack();
        
        for(int j = 0; j<moves.length; j++){
            int line = moves[j]-1;
            for(int i = 0; i <board.length; i++){
                if(board[i][line] != 0) {
                    int cur = board[i][line];
                    board[i][line] = 0;
                    if (!stack.isEmpty() && stack.peek() == cur) {
                        stack.pop();
                        answer += 2;
                        break;
                    }
                    stack.push(cur);
                    break;
                }
            }
        }
        
        return answer;
    }
}