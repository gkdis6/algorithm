https://programmers.co.kr/learn/courses/30/lessons/42748
- 자른 숫자열을 정렬하여 그것의 K번째 수를 골라내기
```java
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i<commands.length; i++){
            int[] ans = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]); //숫자열 잘라내기
            Arrays.sort(ans); //숫자열 정렬
            answer[i] = ans[commands[i][2]-1]; //i번째에 숫자 입력
        }
        
        return answer;
    }
}
```