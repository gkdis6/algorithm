# 평범한 배낭

https://www.acmicpc.net/problem/12865

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
    	StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
    	
		int[][] arr = new int[n][2];
		int[] dp = new int[k+1];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
    	
		for(int i = 0; i<n; i++) {
			for(int j = k; j-arr[i][0] >= 0; j--) {
				dp[j] = Math.max(dp[j], dp[j-arr[i][0]]+arr[i][1]);
			}
		}
		
		System.out.println(dp[k]);
		return;
    }
}
```

