import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static boolean[] visit;
	public static int[] num;
	public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		visit = new boolean[n];
		num = new int[m];
		
		dfs(n, m, 0);
		System.out.println(sb);
    }
    
    public static void dfs(int n, int m, int depth) {
    	if(depth == m) {
    		for(int val : num) {
    			sb.append(val+" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	for(int i = 0; i<n; i++) {
    		if(!visit[i]) {
    			visit[i] = true;
    			num[depth] = i+1;
    			dfs(n, m, depth+1);
    			visit[i] = false;
    		}
    	}
    	return;
    }
}