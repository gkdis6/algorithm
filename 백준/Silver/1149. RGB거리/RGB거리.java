import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[][] pays, cost;
	static int finish;
	static int red = 0;
	static int green = 1;
	static int blue = 2;
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		finish = n;
		pays = new int[n][3];
		cost = new int[n][3];
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pays[i][0] = Integer.parseInt(st.nextToken());
			pays[i][1] = Integer.parseInt(st.nextToken());
			pays[i][2] = Integer.parseInt(st.nextToken());
		}
		cost[0][red] = pays[0][red];
		cost[0][green] = pays[0][green];
		cost[0][blue] = pays[0][blue];
		
		dfs(1);
		
		System.out.println(Math.min(cost[n-1][0], Math.min(cost[n-1][1], cost[n-1][2])));
    }
    
    static void dfs(int depth) {
    	if(depth == finish) {
    		return;
    	}
    	for(int i = 0; i<3; i++) {
    		cost[depth][i] = pays[depth][i] + Math.min(cost[depth-1][(i+1)%3], cost[depth-1][(i+2)%3]); 
    	}
    	dfs(depth+1);
    }
}