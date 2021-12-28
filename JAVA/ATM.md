https://www.acmicpc.net/problem/11399

- greedy 탐색
- Arrays.sort()를 이용해 쉽게 해결

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
    int[] arrays = new int[n];

    for (int i = 0; i < n; i++) {
      arrays[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arrays);
    int sum = 0;
    for(int i = 0; i < n; i++) {
      sum += (n-i) * arrays[i];
    }
    System.out.println(sum);
	}
}
```

