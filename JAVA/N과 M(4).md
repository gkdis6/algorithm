https://www.acmicpc.net/problem/15652

- 이전의 수가 뭐였는지 prev로 받아 처리

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static int[] num;
	public static int n, m;
	public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      num = new int[m];

      dfs(0, 0);
      System.out.println(sb);
    }
    
    public static void dfs(int prev, int depth) {
    	if(depth == m) {
    		for(int val : num) {
    			sb.append(val+" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	for(int i = prev; i<n; i++) {
        num[depth] = i+1;
        dfs(i, depth+1);
    	}
    	return;
    }
}
```

