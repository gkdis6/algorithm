# 사회망 서비스(SNS)

https://www.acmicpc.net/problem/2533

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.*;
 
public class Main {

    static int n;
    static boolean[] visited;
		static Node[] tree;
    static int[][] dp;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        tree = new Node[n + 1];
        dp = new int[n + 1][2];
				visited = new boolean[n + 1];
        
        for(int i  = 1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            tree[parent] = new Node(child, tree[parent]);
            tree[child] = new Node(parent, tree[child]);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int number) {
		visited[number] = true;
		dp[number][0] = 0;
		dp[number][1] = 1;
		
		for(Node next = tree[number]; next != null; next = next.next) {
			if(!visited[next.n]) {
				dfs(next.n);
				dp[number][0] += dp[next.n][1];
				dp[number][1] += Math.min(dp[next.n][0], dp[next.n][1]);
			}
		}
	}

    static class Node {
        int n;
        Node next;
        
        public Node(int n, Node next) {
            this.n = n;
            this.next = next;
        }
    }
}


```

