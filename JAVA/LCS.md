https://www.acmicpc.net/problem/9251

- j를 뒤에서부터 앞으로 돌려 이전 자리의 문자까지의 최대 길이를 구해서 +1
- dp 문제

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		String b = br.readLine();
		
		String[] arr1 = a.split("");
		String[] arr2 = b.split("");
		
		int n1 = arr1.length;
		int n2 = arr2.length;
		int[] dp = new int[n2];
		
		int max = 0;
		
		for(int i = 0; i<n1; i++) {
			for(int j = n2-1; j>=0; j--) {
				max = 0;
				if(arr1[i].equals(arr2[j])) {
					for(int k = 0; k<j; k++) {
						max = Math.max(max, dp[k]+1);
					}
					dp[j] = max; 
				}
			}
			if(arr1[i].equals(arr2[0])) dp[0] = 1;
		}
		for(int i = 0; i<n2; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
```

