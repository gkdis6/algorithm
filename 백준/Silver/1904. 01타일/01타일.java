import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static Integer[] dp = new Integer[1000001];
    public static void main(String[] args) throws IOException{
    	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		dp[1] = 1;
        dp[2] = 2;
		System.out.println(combine2(a));
    }
    
    static int combine2(int a) {
    	if(dp[a] == null){
        	return dp[a] = (combine2(a-1)+combine2(a-2))%15746;
        }
		return dp[a];
    }
}