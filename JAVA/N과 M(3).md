https://www.acmicpc.net/problem/15651

- 모든 경우의 수라서 더 쉬웠던 문제

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
		
		dfs(0);
		System.out.println(sb);
    }
    
    public static void dfs(int depth) {
    	if(depth == m) {
    		for(int val : num) {
    			sb.append(val+" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	for(int i = 0; i<n; i++) {
            num[depth] = i+1;
            dfs(depth+1);
    	}
    	return;
    }
}
```

