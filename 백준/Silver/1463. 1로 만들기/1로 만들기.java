import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int min = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		dfs(n, 0);
		System.out.println(min);
  }
  static void dfs(int n, int answer) {
    if(n == 1) {
      min = Math.min(answer, min);
      return;
    }
    if(min < answer) return;
    if(n%3 == 0) {
      dfs(n/3, answer+1);
    }
    if(n%3 == 1) {
      dfs((n-1)/3, answer+2);
    }
    if(n%2 == 0) {
      dfs(n/2, answer+1);
    }
    dfs(n-1, answer+1);
    return;
  }
}