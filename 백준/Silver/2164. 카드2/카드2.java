import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> que = new LinkedList<>();
		for(int i = 1; i<=n; i++) {
			que.add(i);
		}
		while(que.size()>1) {
			que.poll();
			que.add(que.poll());
		}
		System.out.println(que.poll());
    }
	
}
