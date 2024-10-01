import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] visited;
	static ArrayList<Integer>[] arr;
	static boolean arrive = false;
	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		for(int i = 0; i<n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s].add(e);
			arr[e].add(s);
		}
		for(int i = 0; i < n; i++) {
			DFS(i,1);
			if(arrive) break;
		}
		if(arrive) System.out.println("1");
		else System.out.println("0");
    }
	private static void DFS(int i, int depth) {
		if(depth == 5 || arrive) {
			arrive = true;
			return;
		}
		visited[i] = true;
		for(int l : arr[i]) {
			if(!visited[l]) {
				DFS(l, depth+1);
			}
		}
		visited[i] = false;
	}
}
