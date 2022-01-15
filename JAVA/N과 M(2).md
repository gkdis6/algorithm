https://www.acmicpc.net/problem/15650

- 중복되는 수열은 제외된 출력

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static boolean[] visit;
	public static int[] num;
	public static int n, m;
	public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visit = new boolean[n];
		num = new int[m];
		
		dfs(0, 0);
		System.out.println(sb);
    }
    
    public static void dfs(int at, int depth) {
    	if(depth == m) {
    		for(int val : num) {
    			sb.append(val+" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	for(int i = at; i<n; i++) {
    		if(!visit[i]) {
    			visit[i] = true;
    			num[depth] = i+1;
    			dfs(i+1, depth+1);
    			visit[i] = false;
    		}
    	}
    	return;
    }
}
```

