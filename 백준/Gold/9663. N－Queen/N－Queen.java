import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static boolean[] pos, rightup, rightdown; 
	public static int answer = 0;
    public static void main(String[] args) throws IOException{
    	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		pos = new boolean[n];
		rightup = new boolean[2*n-1];
		rightdown = new boolean[2*n-1];
		
		dfs(0, n);
		System.out.println(answer);
    }
    
    public static void dfs(int start, int leng) {
    	if(leng == start) {
    		answer++;
    		return;
    	}
    	for(int i = 0; i<leng; i++) {
    		if(!pos[i] && !rightdown[leng+start-i-1] && !rightup[start+i]) {
				pos[i] = true;
				rightdown[leng+start-i-1] = true;
				rightup[start+i] = true;
				dfs(start+1, leng);
				pos[i] = false;
				rightdown[leng+start-i-1] = false;
				rightup[start+i] = false;
    		}
    	}
    	return;
    }
}