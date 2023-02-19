N-Queen

https://school.programmers.co.kr/learn/courses/30/lessons/12952?language=java

```java
class Solution {
    public static boolean[] pos, rightup, rightdown; 
	public static int answer = 0;
    public int solution(int n) {
        pos = new boolean[n];
        rightup = new boolean[2*n-1];
        rightdown = new boolean[2*n-1];

        dfs(0, n);
        return answer;
    }
    
    public static void dfs(int start, int leng) {
        if(leng == start) {
          answer++;
          return;
        }
        for(int i = 0; i<leng; i++) {
            if(!pos[i] && !rightdown[leng+start-i-1] && !rightup[start+i]) {
                pos[i] = true;
                rightdown[leng+start-i-1] = true;
                rightup[start+i] = true;
                dfs(start+1, leng);
                pos[i] = false;
                rightdown[leng+start-i-1] = false;
                rightup[start+i] = false;
            }
        }
        return;
    }
}
```

