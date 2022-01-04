https://programmers.co.kr/learn/courses/30/lessons/42895#

- 동적프로그래밍으로 풀려고 했지만 dfs가 훨씬 쉬움

```java
import java.util.*;

class Solution {
    static int answer=-1;
    public int solution(int N, int number) {
        dfs(N, number,0,0);
        return answer;
    }
	public static void dfs(int N, int number, int count, int sum) {
		if(count>8) return;
		if(number==sum)	{
			if(answer==-1)	answer=count;
			else answer=Math.min(answer, count);
		}
		int X=N;
		for(int i=1;i<=8-count;i++) {
			dfs(N,number,i+count,sum+X);
			dfs(N,number,i+count,sum-X);
			dfs(N,number,i+count,sum*X);
			dfs(N,number,i+count,sum/X);
			X=(10*X)+N;
		}
		
	}
}
```

