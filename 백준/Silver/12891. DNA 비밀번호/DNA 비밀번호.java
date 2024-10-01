import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String full = br.readLine();
		Character[] arr = new Character[n];
		for(int i = 0; i<n; i++) {
			arr[i] = full.charAt(i);
		}
		int[] code = new int[4];
		int[] find = new int[4];
		int counter = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<4; i++) {
			code[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i<k; i++) {
			if(arr[i]=='A') find[0]++;
			else if(arr[i]=='C') find[1]++;
			else if(arr[i]=='G') find[2]++;
			else if(arr[i]=='T') find[3]++;
		}
		int result = 0;
		for(int l = 0; l<4; l++) {
			if(code[l]<=find[l]) {
				result++;
			}
		}
		if(result == 4) counter++;
		
		for(int i = k; i<n; i++) {
			int j = i-k;
			if(arr[i]=='A') {
				find[0]++;
				if(code[0] == find[0]) result++;
			}
			else if(arr[i]=='C') {
				find[1]++;
				if(code[1] == find[1]) result++;
			}
			else if(arr[i]=='G') {
				find[2]++;
				if(code[2] == find[2]) result++;
			}
			else if(arr[i]=='T') {
				find[3]++;
				if(code[3] == find[3]) result++;
			}
			
			if(arr[j]=='A') {
				if(code[0] == find[0]) result--;
				find[0]--;
			}
			else if(arr[j]=='C') {
				if(code[1] == find[1]) result--;
				find[1]--;
			}
			else if(arr[j]=='G') {
				if(code[2] == find[2]) result--;
				find[2]--;
			}
			else if(arr[j]=='T') {
				if(code[3] == find[3]) result--;
				find[3]--;
			}
			
			if(result == 4) counter++;
		}
		
		System.out.println(counter);
		return;
    }
}